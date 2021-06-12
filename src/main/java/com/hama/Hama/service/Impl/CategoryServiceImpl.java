package com.hama.Hama.service.Impl;

import com.hama.Hama.dao.CategoryDao;
import com.hama.Hama.entities.CategoryEntity;
import com.hama.Hama.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryDao categoryDao;

    @Override
    @Transactional
    public Integer saveCategory(CategoryEntity category) {
        return categoryDao.saveCategory(category);
    }

    @Override
    @Transactional
    public void deleteCategory(Integer id) {
        categoryDao.deleteCategory(id);
    }

    @Override
    @Transactional
    public List<CategoryEntity> getCategories() {
        return categoryDao.getCategories();
    }

    @Override
    @Transactional
    public CategoryEntity getCategory(Integer id) {
        return categoryDao.getCategory(id);
    }

}
