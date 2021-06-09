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
    public CategoryEntity saveCategory(CategoryEntity category) {
        return categoryRepository.save(category);
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
    public CategoryEntity getCategoryById(Integer id) {
        Optional<CategoryEntity> categoryEntityOptional = categoryRepository.findById(id);
       if (categoryEntityOptional.equals("")) 
           return new CategoryEntity();
        
        return categoryEntityOptional.get();
    }
}
