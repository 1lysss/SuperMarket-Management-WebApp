package com.pfe.SuperMarketManager.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor

public class Product {

    public enum Unit {
        PACK,
        KG,
        LITER,
        ITEM
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private Unit unit;
    private LocalDate expiryDate;
    private String name;
    private float quantity;

}

