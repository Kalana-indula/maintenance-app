package com.myplant.maintenance.service;

import com.myplant.maintenance.entity.Category;
import com.myplant.maintenance.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    //Get an instance of 'CategoryRepository'
    @Autowired
    private CategoryRepository categoryRepository;

    //Create a new category
    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    //Get all categories as a list
    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    //Find a category by its id
    @Override
    public Category findCategoryById(Long id) {

        return categoryRepository.findById(id).orElse(null);
    }

    //Update an existing category
    @Override
    public Category updateCategory(Long id, Category category) {

        //Find the category for corresponding Id
        Category existingCategory=categoryRepository.findById(id).orElse(null);

        //Check if the category is existing
        if(existingCategory!=null){
            existingCategory.setCategoryName(category.getCategoryName());

            return categoryRepository.save(existingCategory);
        }else{
            return null;
        }

    }

    //Deleting an existing category
    @Override
    public Boolean deleteCategory(Long id) {

        //Check if the category is existing
        boolean isExist=categoryRepository.existsById(id);

        if(isExist){
            categoryRepository.deleteById(id);
            return true;
        }else{
            return false;
        }

    }
}
