package com.example.productservice.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
//blabl
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    private String productName;
    private String description;
    private String productOwner_UserName;
    @ManyToOne
    @JoinColumn(name = "souscategory_id")
    private Sous_Category sous_category;

}
