package com.pfe.SuperMarketManager.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "stock_requests")
@Data
@NoArgsConstructor

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
}
