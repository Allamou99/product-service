package com.example.productservice.service;

import com.example.productservice.dtos.ProductDTO;
import com.example.productservice.model.Product;
import com.example.productservice.model.Sous_Category;
import com.example.productservice.repository.ProductRepo;
import com.example.productservice.repository.SousCategorieRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private SousCategorieService sousCategorieService;
    private ProductRepo productRepo;
    public List<ProductDTO> getListofproductsOfSousCat(String sc_name){
        List<ProductDTO> productDTOS = new ArrayList<>();
        Sous_Category sc = this.sousCategorieService.getSousCategoryByName(sc_name);
        List<Product> products = sc.getProducts();
        products.stream().forEach(product -> productDTOS
                .add(new ProductDTO(product.getProductName(),product.getDescription())));
        return productDTOS;
    }
    public String addProductToSousCategory(String sc_name,ProductDTO productDTO){
        Sous_Category sc = this.sousCategorieService.getSousCategoryByName(sc_name);
        Product product = Product.builder()
                .productName(productDTO.getProductName())
                .description(productDTO.getDescription())
                .sous_category(sc)
                .productOwner_UserName(this.getUsernameFromUserdetails())
                .build();
        this.productRepo.save(product);
        return "Product";
    }
    private String getUsernameFromUserdetails(){
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) SecurityContextHolder.
                getContext().getAuthentication().getPrincipal();
        return principal.getUsername();
    }
}
