package com.codewithmosh.store.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column (name = "description")
    private String description;

    @Column (name ="price")
    private BigDecimal price;

    @ManyToOne (cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "categories_id")
    @ToString.Exclude
    private Category category;
}
