package com.myplant.maintenance.controller;

import com.myplant.maintenance.entity.Category;
import com.myplant.maintenance.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    //Creating an instance of "Category Service"
    @Autowired
    private CategoryService categoryService;

    //Create an API for create a new category
    @PostMapping("/create/categories")
    public ResponseEntity<?> createCategory(@RequestBody Category category){
        try{
            Category newCategory=categoryService.createCategory(category);

            return ResponseEntity.status(HttpStatus.OK).body(newCategory);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    //Create an API for get all exising categories
    @GetMapping("/categories")
    public ResponseEntity<?> getAllCategories(){
        try {
            List<Category> categories=categoryService.findAllCategories();

            return ResponseEntity.status(HttpStatus.OK).body(categories);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    //Create an API for find a category by its id
    @GetMapping("/categories/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Long id){
        try {
            Category category=categoryService.findCategoryById(id);

            if(category!=null){
                return ResponseEntity.status(HttpStatus.OK).body(category);
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category Nof Found");
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    //Create an API for update an existing category
    @PutMapping("/update/categories/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Long id,@RequestBody Category category){
        try{
            Category updatedCategory=categoryService.updateCategory(id,category);

            if(updatedCategory!=null){
                return ResponseEntity.status(HttpStatus.OK).body(updatedCategory);
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category Not Found");
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    //Create an API for delete an existing category
    @DeleteMapping("/delete/categories/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id){
        try {
            boolean isDeleted= categoryService.deleteCategory(id);

            if(isDeleted){
                return ResponseEntity.status(HttpStatus.OK).body("Category Deleted Successfully");
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category Not Found");
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }
}
