package com.example.productservice.dtos;

import com.example.productservice.model.Sous_Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@Builder
public class CategoriesDTO {
    private String categoryName;
    private List<SousCategorieDTO> sousCategories;
}
