package com.hama.Hama.service;

import com.hama.Hama.entities.ProductEntity;

import java.util.List;

public interface ProductService {

    int saveProduct(ProductEntity productEntity);

    void deleteProduct(Integer id);

    List<ProductEntity> getProducts();

    ProductEntity getProduct(Integer id);

}
