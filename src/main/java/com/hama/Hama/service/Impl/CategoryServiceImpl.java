package com.hama.Hama.service.Impl;

import com.hama.Hama.entities.CategoryEntity;
import com.hama.Hama.repository.CategoryRepository;
import com.hama.Hama.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public void saveCategory(CategoryEntity category) {
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategoryById(Integer id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<CategoryEntity> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<CategoryEntity> getCategoryById(Integer id) {
        return categoryRepository.findById(id);
    }
}
