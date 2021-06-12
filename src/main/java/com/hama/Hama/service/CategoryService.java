package com.hama.Hama.service;

import com.hama.Hama.entities.CategoryEntity;

import java.util.List;

public interface CategoryService {

    Integer saveCategory(CategoryEntity category);

    void deleteCategory(Integer id);

    List<CategoryEntity> getCategories();

    CategoryEntity getCategory(Integer id);


}
