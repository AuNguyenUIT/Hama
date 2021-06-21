package com.hama.Hama.dao;

import com.hama.Hama.entities.ProductEntity;

import java.util.List;

public interface ProductDao {

    List<ProductEntity> getProducts();

    int saveProduct(ProductEntity productEntity);

    void deleteProduct(int id);

    ProductEntity getProduct(int id);

    List<ProductEntity> getProductByCategoryAndName(Integer category_id, String title);

    List<ProductEntity> getProductsByQuery(String query);
}
