package com.hama.Hama.service;

import com.hama.Hama.entities.ProductEntity;

import java.util.List;

public interface ProductService {
    int saveProduct(ProductEntity productEntity);

    Boolean deleteProduct(Integer id);

    List<ProductEntity> getProducts();

    ProductEntity getProduct(Integer id);

    List<ProductEntity> getProductByCategoryAndName(Integer category_id, String title);

    List<ProductEntity> getProductsByQuery(String queryString);

}
