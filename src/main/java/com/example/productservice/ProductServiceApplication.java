package com.example.productservice;

import com.example.productservice.model.Category;
import com.example.productservice.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class ProductServiceApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }
    //private final CategoryService categoryService;
    @Override
    public void run(String... args) throws Exception {
        /*
        Category category1 = Category.builder()
                .categoryName("Electronique")
                .build();
        Category category2 = Category.builder()
                .categoryName("Electromenagé")
                .build();

        this.categoryService.saveCategory(category1);
        this.categoryService.saveCategory(category2);

         */

    }
}
