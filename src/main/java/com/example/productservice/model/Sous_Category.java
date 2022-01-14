package com.example.productservice.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Sous_Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int SCId;
    @JsonProperty(value = "SCName")
    private String SCName;
    private String description;

    @ManyToOne()
    @JoinColumn(name = "category_id" )
    private Category category;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "sous_category")
    private List<Product> products;
}
