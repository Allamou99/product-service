package com.example.productservice.repository;

import com.example.productservice.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepo extends JpaRepository<Category,Integer> {

    Optional<Category> findByCategoryName(String name);
}
