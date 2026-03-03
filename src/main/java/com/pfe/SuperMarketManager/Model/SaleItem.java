package com.pfe.SuperMarketManager.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "sale_items")
@Data
@NoArgsConstructor

public class SaleItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private BigDecimal quantity;
    private BigDecimal price;

    // Many sale items can have the same product (product bought multiple times)
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;  // links to price? ask Claude

    // Many sale items belong to a single sale for each purchase made
    @ManyToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;
}
