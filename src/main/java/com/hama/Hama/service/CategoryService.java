package com.hama.Hama.service;

import com.hama.Hama.entities.CategoryEntity;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    void saveCategory(CategoryEntity category);

    void deleteCategoryById(Integer id);

    List<CategoryEntity> getAll();

    Optional<CategoryEntity> getCategoryById(Integer id);


}
