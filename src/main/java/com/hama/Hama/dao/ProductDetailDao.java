package com.hama.Hama.dao;

import com.hama.Hama.model.ProductDetail;

import java.util.List;

public interface ProductDetailDao {
    void insert(ProductDetail productDetail);

    void edit(ProductDetail productDetail);

    void delete(int id);

    ProductDetail get(int id);

    List<ProductDetail> getAll();

    List<ProductDetail> searchByName(String productName);
}
