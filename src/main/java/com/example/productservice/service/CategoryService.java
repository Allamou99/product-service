package com.example.productservice.service;



import com.example.productservice.dtos.CategoriesDTO;
import com.example.productservice.exceptions.CategoryException;
import com.example.productservice.model.Category;
import com.example.productservice.repository.CategoryRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepo categoryRepo;
    public Category saveCategory(Category category){
        return this.categoryRepo.save(category);
    }
    public List<Category> getAllCategories(){
        List<Category> categories = this.categoryRepo.findAll();
        return categories;
    }

    public Category findCategoryByName(String name){
        return this.categoryRepo.findByCategoryName(name)
                .orElseThrow(()-> new CategoryException("No category with this name"));
    }
}
