package com.pfe.SuperMarketManager.Model.Enums;

import lombok.Getter;

@Getter
public enum Unit {
    KG("Kg"),
    G("g"),
    UNIT("Unit"),
    LITER("Liter"),
    PACK("Pack");

    private final String label;

    Unit(String label) {
        this.label = label;
    }
}
