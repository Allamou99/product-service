package com.example.productservice.controllers;


import com.example.productservice.dtos.SousCategorieDTO;
import com.example.productservice.model.Sous_Category;
import com.example.productservice.service.SousCategorieService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/souscategories")
@AllArgsConstructor
public class SousCategorieController {
    private SousCategorieService sousCategorieService;

    //get all sous categories from a category
    @GetMapping("/{category}")
    public List<SousCategorieDTO> getSousCategoryByCategoryName(@PathVariable String category){
        return this.sousCategorieService.getAllSousCategoryOfCategory(category);
    }

    //add a sous category to a category
    @PostMapping("/addSC/{categoryName}")
    public String addSousCategoryToCategory(@RequestBody Sous_Category sous_category,
                                            @PathVariable String categoryName){
        return this.sousCategorieService.addSousCategory(categoryName,sous_category);
    }
}
