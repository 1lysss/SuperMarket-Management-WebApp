package com.pfe.SuperMarketManager.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "stock requests")

public class StockRequest {
    public enum Status {
        PENDING,
        DECLINED,
        APPROVED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private BigDecimal quantityRequested;
    private Status status;
    private LocalDate requestDate;
    // TODO: product id

    public StockRequest() {};

    public StockRequest(Integer id, BigDecimal quantityRequested, Status status, LocalDate requestDate) {
        this.id = id;
        this.quantityRequested = quantityRequested;
        this.status = status;
        this.requestDate = requestDate;
    }


}
