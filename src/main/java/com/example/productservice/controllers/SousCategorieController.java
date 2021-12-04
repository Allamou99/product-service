package com.example.productservice.controllers;


import com.example.productservice.model.Sous_Category;
import com.example.productservice.repository.SousCategorieRepo;
import com.example.productservice.service.SousCategorieService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/souscategories")
@AllArgsConstructor
public class SousCategorieController {
    private SousCategorieService sousCategorieService;
    @PostMapping("/{categoryName}")
    public String saveSousCategories(@PathVariable("categoryName") String categoryName){
        this.sousCategorieService.AddSousCategoriesToCategories(categoryName);
        return "Done";
    }
    @GetMapping
    public List<Sous_Category> sous_categories(){
        return this.sousCategorieService.getallsCategories();
    }
}