package com.hama.Hama.dao;

import com.hama.Hama.entities.ProductVariationEntity;

import java.util.List;

public interface ProductVariationDao {
    void insert(ProductVariationEntity productVariation);

    void edit(ProductVariationEntity productVariation);

    void delete(int id);

    ProductVariationEntity get(int id);

    List<ProductVariationEntity> getAll();

    List<ProductVariationEntity> searchByName(String productName);
}
