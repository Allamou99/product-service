package com.example.productservice.service;

import com.example.productservice.model.Product;
import com.example.productservice.repository.SousCategorieRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private SousCategorieRepo sousCategorieRepo;
    /*
    public List<Product> allProductsForSubcategory(String subcategory){

    }
     */

}
