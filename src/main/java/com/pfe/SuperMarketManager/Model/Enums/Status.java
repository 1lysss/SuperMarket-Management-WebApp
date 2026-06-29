package com.pfe.SuperMarketManager.Model.Enums;

import lombok.Getter;

@Getter
public enum Status {
    APPROVED("Approved"),
    REJECTED("Rejected"),
    PENDING("Pending");

    private final String status;

    Status(String status) {
        this.status = status;
    }
}
