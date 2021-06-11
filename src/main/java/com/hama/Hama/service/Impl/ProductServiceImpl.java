package com.hama.Hama.service.Impl;

import com.hama.Hama.dao.ProductDao;
import com.hama.Hama.entities.ProductEntity;
import com.hama.Hama.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    @Override
    @Transactional
    public int saveProduct(ProductEntity productEntity) {
        return productDao.saveProduct(productEntity);
    }

    @Override
    @Transactional
    public void deleteProduct(Integer id) {
        try {
            productDao.deleteProduct(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<ProductEntity> getProducts() {
        return productDao.getProducts();
    }

    @Override
    @Transactional
    public ProductEntity getProduct(Integer id) {
        return productDao.getProduct(id);
    }


}
