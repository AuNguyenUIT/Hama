package com.hama.Hama.service;

import com.hama.Hama.entities.ProductEntity;

import java.util.List;

public interface ProductService {

    ProductEntity saveProduct(ProductEntity productEntity);

    void deleteProductById(Integer id);

    List<ProductEntity> getAll();

    ProductEntity getProductById(Integer id);

}
