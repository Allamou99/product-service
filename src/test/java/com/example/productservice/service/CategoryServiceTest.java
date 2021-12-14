package com.example.productservice.service;

import com.example.productservice.exceptions.CategoryException;
import com.example.productservice.model.Category;
import com.example.productservice.repository.CategoryRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CategoryServiceTest {
    private CategoryRepo categoryRepo = Mockito.mock(CategoryRepo.class);
    CategoryService categoryService;
    Category expectedReturn;
    Category category;
    @BeforeEach
    void Initialization(){
        this.categoryService = new CategoryService(categoryRepo);
        category = Category.builder()
                .categoryName("Electronique")
                .build();
        expectedReturn =  Category.builder()
                .categoryName("Electronique")
                .build();
    }
    //bla
    @Test
    @DisplayName("Should save category correctly")
    void SaveCategoryTest() {
        when(this.categoryRepo.save(category)).thenReturn(expectedReturn);
        Category categoryTest = categoryService.saveCategory(category);
        assertThat(categoryTest).isEqualTo(category);
    }
    @DisplayName("Should fin category by its name.")
    @Test
    void FindCategoryByNameTest(){
        when(this.categoryRepo.findByCategoryName("Electronique"))
                .thenReturn(Optional.of(expectedReturn));
        Category categoryTest = categoryService.findCategoryByName("Electronique");
        assertThat(categoryTest).isEqualTo(expectedReturn);
    }
    @DisplayName("Should raise No category with name found exception")
    @Test
    void NoCategoryFindByNameException(){
        assertThatThrownBy(()->{
            when(this.categoryRepo.findByCategoryName("Electronique"))
                    .thenReturn(Optional.of(expectedReturn));
            categoryService.findCategoryByName("Electroniquee");
        }).isInstanceOf(CategoryException.class)
                .hasMessage("No category with this name");
    }
}