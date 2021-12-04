package com.example.productservice.repository;

import com.example.productservice.model.Sous_Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SousCategorieRepo extends JpaRepository<Sous_Category,Integer> {
}
