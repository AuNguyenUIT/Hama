package com.hama.Hama.service.Impl;

import com.hama.Hama.entities.CategoryEntity;
import com.hama.Hama.entities.ProductEntity;
import com.hama.Hama.repository.ProductRepository;
import com.hama.Hama.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public ProductEntity saveProduct(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }

    @Override
    public void deleteProductById(Integer id) {
        try {
            productRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<ProductEntity> getAll() {
        return productRepository.findAll();
    }

    @Override
    public ProductEntity getProductById(Integer id) {
        Optional<ProductEntity> productEntityOptional = productRepository.findById(id);
        if (productEntityOptional.isEmpty()) {
            return new ProductEntity();
        }
        return productEntityOptional.get();
    }


}
