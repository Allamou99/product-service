package com.example.productservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class SousCategorieDTO {
    private String sousCatName;
    private String description;
    private int productNumber;
}
