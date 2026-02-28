package com.pfe.SuperMarketManager.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "products")
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


    public Product() {}; // for JPA

    public Product(Integer id, BigDecimal price, Unit unit, LocalDate expiryDate, String name, float quantity) {
        this.id = id;
        this.unit = unit;
        this.expiryDate = expiryDate;
        this.price = price;
        this.name = name;
        this.quantity = quantity;
    }

    public float getQuantity() {
        return quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

