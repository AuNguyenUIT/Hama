package com.hama.Hama.dao;

import com.hama.Hama.model.Product;

import java.util.List;

public interface ProductDao {
    void insert(Product product);

    void edit(Product product);

    void delete(int id);

    Product get(int id);

    List<Product> getAll();

    List<Product> searchByName(String productName);
}
