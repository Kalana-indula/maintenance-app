package com.myplant.maintenance.service;

import com.myplant.maintenance.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    //Create a category
    Category createCategory(Category category);

    //Get a list of categories
    List<Category> findAllCategories();

    //Find a category for a given id
    Category findCategoryById(Long id);

    //Update an existing category
    Category updateCategory(Long id,Category category);

    //Delete an existing category
    Boolean deleteCategory(Long id);
}
