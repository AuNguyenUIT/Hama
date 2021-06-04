package com.hama.Hama.service;

import com.hama.Hama.entities.CategoryEntity;

import java.util.List;

public interface CategoryService {

    CategoryEntity saveCategory(CategoryEntity category);

    void deleteCategoryById(Integer id);

    List<CategoryEntity> getAll();

    CategoryEntity getCategoryById(Integer id);


}
