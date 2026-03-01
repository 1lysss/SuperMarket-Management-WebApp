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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//  private Integer saleId;
    private Integer productId;
    private BigDecimal quantity;
    private BigDecimal price;

}
