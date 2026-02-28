package com.pfe.SuperMarketManager.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "Sale items")
public class SaleItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//  private Integer saleId;
    private Integer productId;
    private BigDecimal quantity;
    private BigDecimal price;

    public SaleItem() {};

    public SaleItem(Integer id, Integer productId, BigDecimal quantity, BigDecimal price) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
