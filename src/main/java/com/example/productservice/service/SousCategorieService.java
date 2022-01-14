package com.example.productservice.service;

import com.example.productservice.dtos.SousCategorieDTO;
import com.example.productservice.exceptions.CategoryException;
import com.example.productservice.model.Category;
import com.example.productservice.model.Sous_Category;
import com.example.productservice.repository.SousCategorieRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class SousCategorieService {
    private CategoryService categoryService;
    private SousCategorieRepo sousCategorieRepo;


    public Sous_Category getSousCategoryByName(String name){
        return this.sousCategorieRepo.findBySCName(name)
                .orElseThrow(()-> new CategoryException("No sous category found"));
    }

    public String addSousCategory(String categoryName, Sous_Category sous_category){
        Category category = this.categoryService.findCategoryByName(categoryName);
        sous_category.setCategory(category);
        sousCategorieRepo.save(sous_category);
        this.categoryService.saveCategory(category);
        return "Sous category added";
    }

    public List<SousCategorieDTO> getAllSousCategoryOfCategory(String categoryName){
        List<SousCategorieDTO> sousCategorieDTOS = new ArrayList<>();
        Category category = this.categoryService.findCategoryByName(categoryName);
        category.getSousCategories().stream()
                .forEach(sous_category -> sousCategorieDTOS.add(new SousCategorieDTO(sous_category.getSCName(),
                        sous_category.getDescription(),sous_category.getProducts().size())));
        return sousCategorieDTOS;
    }
}


/*
List<SousCategorieDTO> sousCategorieDTOS = new ArrayList<>();
        category.getSousCategories().stream()
                .forEach(sous_category -> sousCategorieDTOS.add(new SousCategorieDTO(sous_category.getSCName())));
        return sousCategorieDTOS;
 */