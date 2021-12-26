package com.example.productservice.controllers;

import com.example.productservice.dtos.CategoriesDTO;
import com.example.productservice.dtos.SousCategorieDTO;
import com.example.productservice.model.Category;
import com.example.productservice.service.CategoryService;
import com.example.productservice.service.SousCategorieService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/categories")
@RestController
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    private final SousCategorieService sousCategorieService;
    @PostMapping("/init")
    public void InitCategories(){
        Category category1 = Category.builder()
                .categoryName("Electronique")
                .build();
        Category category2 = Category.builder()
                .categoryName("Electromenagé")
                .build();
        this.categoryService.saveCategory(category1);
        this.categoryService.saveCategory(category2);
    }

    @GetMapping("/{CategoryName}")
    public CategoriesDTO categoryByName(@PathVariable("CategoryName") String name){
        return this.categoryService.findCategoryByNameRequest(name);
    }
}

/*
List<Category> categories =  this.categoryService.getAllCategories();
        List<CategoriesDTO> categoriesDTOS = new ArrayList<>();
        categories.stream().forEach(category -> categoriesDTOS
                .add(new CategoriesDTO(category.getCategoryName(),
                        this.sousCategorieService.getSouscategoriesDTOfromcategorie(category))));
        return categoriesDTOS;
 */
