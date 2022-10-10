package byfayzullayev.startup.service.impl;

import byfayzullayev.startup.Repository.CategoryRepository;
import byfayzullayev.startup.entity.questions.CategoryEntity;
import byfayzullayev.startup.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryEntity addCategory(CategoryEntity category) {
        return categoryRepository.save(category);
    }

    @Override
    public CategoryEntity updateCategory(CategoryEntity category) {
        return categoryRepository.save(category);
    }

    @Override
    public Set<CategoryEntity> getCategories() {
        return new LinkedHashSet<>(categoryRepository.findAll());
    }

    @Override
    public CategoryEntity getCategory(Long categoryId) {
        return categoryRepository.findById(categoryId).get();
    }

    @Override
    public void deleteCategory(Long categoryId) {
        CategoryEntity category = new CategoryEntity();
        category.setId(categoryId);
        categoryRepository.delete(category);

    }
}
