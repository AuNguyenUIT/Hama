package com.hama.Hama.dao;

import com.hama.Hama.entities.ProductEntity;

import java.util.List;

public interface ProductDao {
    void insert(ProductEntity product);

    void edit(ProductEntity product);

    void delete(int id);

    ProductEntity get(int id);

    List<ProductEntity> getAll();

    List<ProductEntity> searchByName(String productName);
}
