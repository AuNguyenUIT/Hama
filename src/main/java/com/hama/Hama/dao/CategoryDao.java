package com.hama.Hama.dao;

import com.hama.Hama.entities.CategoryEntity;

import java.util.List;

public interface CategoryDao {
    void insert(CategoryEntity category);

    void edit(CategoryEntity category);

    void delete(int id);

    CategoryEntity get(int id);

    List<CategoryEntity> getAll();
}
