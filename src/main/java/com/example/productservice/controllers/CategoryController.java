package com.example.productservice.controllers;

import com.example.productservice.model.Category;
import com.example.productservice.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/categories")
@RestController
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/{CategoryName}")
    public Category categoryByName(@PathVariable("CategoryName") String name){
        return this.categoryService.findCategoryByName(name);
    }
}
