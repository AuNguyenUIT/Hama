package com.hama.Hama.dao;

import com.hama.Hama.entities.CategoryEntity;
import java.util.List;

public interface CategoryDao {
    List<CategoryEntity> getCategories();

    int saveCategory(CategoryEntity CategoryEntity);

    void deleteCategory(int id);

    CategoryEntity getCategory(int id);
}
