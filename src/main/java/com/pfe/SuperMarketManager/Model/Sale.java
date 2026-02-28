package com.pfe.SuperMarketManager.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.stream.Gatherer;

@Entity
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//    private Integer cashier_id;
//    private BigDecimal totalPrice;
    private LocalDate saleDate;

    public Sale() {};

    public Sale(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
