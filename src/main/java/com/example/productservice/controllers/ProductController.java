package com.example.productservice.controllers;


import com.example.productservice.dtos.ProductDTO;
import com.example.productservice.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/products")
@RestController
@AllArgsConstructor
public class ProductController {
    private ProductService productService;

    @GetMapping("/{scname}")
    public List<ProductDTO> getAllProducts(@PathVariable String scname){
        return this.productService.getListofproductsOfSousCat(scname);
    }

    @PostMapping("/{scname}")
    public String addProductToSc(@PathVariable String scname,@RequestBody ProductDTO productDTO){
        return this.productService.addProductToSousCategory(scname,productDTO);
    }
}
