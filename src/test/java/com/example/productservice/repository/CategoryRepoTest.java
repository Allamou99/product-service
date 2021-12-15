package com.example.productservice.repository;

import com.example.productservice.model.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")


//testcategoryrepository
class CategoryRepoTest {
    @Autowired
    private CategoryRepo categoryRepo;
    @BeforeEach
    void CleanH2Database(){
        this.categoryRepo.deleteAll();
    }
    @Test
    void SaveCategory() {
        Category category = Category.builder()
                .categoryName("Electronique")
                .build();
        Category savedCategory = this.categoryRepo.save(category);
        assertThat(savedCategory).usingRecursiveComparison().ignoringFields("categoryId").isEqualTo(category);
    }
    @Test
    void FindCategoryByName(){
        Category category = Category.builder()
                .categoryName("Electronique")
                .build();
        this.categoryRepo.save(category);
        Optional<Category> categoryTest = this.categoryRepo.findByCategoryName("Electronique");
        assertThat(categoryTest).isNotEmpty();
    }
}