package com.example.productservice.service;

import com.example.productservice.dtos.SousCategorieDTO;
import com.example.productservice.exceptions.CategoryException;
import com.example.productservice.model.Category;
import com.example.productservice.model.Sous_Category;
import com.example.productservice.repository.CategoryRepo;
import com.example.productservice.repository.SousCategorieRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class SousCategorieService {
    private CategoryService categoryService;
    private SousCategorieRepo sousCategorieRepo;
    public void AddSousCategoriesToCategories(String categorieName){
        Category category = this.categoryService.findCategoryByName(categorieName);
        Sous_Category sous_category1 = Sous_Category.builder()
                .SCName("Ordinateurs")
                .category(category)
                .build();
        Sous_Category sous_category2 = Sous_Category.builder()
                .SCName("Portables")
                .category(category)
                .build();
        this.sousCategorieRepo.save(sous_category1);
        this.sousCategorieRepo.save(sous_category2);
    }
    public List<Sous_Category> getallsCategories(){
        return this.sousCategorieRepo.findAll();
    }

    public List<SousCategorieDTO> getSouscategoriesDTOfromcategorie(Category category){
        List<SousCategorieDTO> sousCategorieDTOS = new ArrayList<>();
        category.getSousCategories().stream()
                .forEach(sous_category -> sousCategorieDTOS.add(new SousCategorieDTO(sous_category.getSCName())));
        return sousCategorieDTOS;
    }
    public Sous_Category getSousCategoryByName(String name){
        return this.sousCategorieRepo.findBySCName(name)
                .orElseThrow(()-> new CategoryException("No sous category found"));
    }
}
