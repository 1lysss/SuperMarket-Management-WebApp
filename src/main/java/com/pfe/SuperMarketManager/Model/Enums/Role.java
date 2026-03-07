package com.pfe.SuperMarketManager.Model.Enums;

import lombok.Getter;

@Getter
public enum Role {
    ADMIN("Admin"),
    STOCK_MANAGER("Stock manager"),
    CASHIER("Cashier");

    private final String role;

    Role(String role) {
        this.role = role;
    }
}
