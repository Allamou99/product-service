package com.example.productservice.repository;

import com.example.productservice.model.Sous_Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SousCategorieRepo extends JpaRepository<Sous_Category,Integer> {
    Optional<Sous_Category> findBySCName(String name);

}
