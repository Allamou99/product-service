package com.example.productservice.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Sous_Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int typeId;
    private String typeName;

    @ManyToOne()
    @JoinColumn(name = "category_id" )
    private Category category;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "sous_category")
    private Set<Product> products;
}
