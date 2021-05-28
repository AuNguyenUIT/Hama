package com.hama.Hama.dao;

import com.hama.Hama.model.Category;

import java.util.List;

public interface CategoryDao {
    void insert(Category category);

    void edit(Category category);

    void delete(int id);

    Category get(int id);

    List<Category> getAll();
}
