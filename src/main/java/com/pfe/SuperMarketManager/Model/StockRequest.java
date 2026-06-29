package com.pfe.SuperMarketManager.Model;

import com.pfe.SuperMarketManager.Model.Enums.Status;
import com.pfe.SuperMarketManager.Model.Enums.Unit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "stock_requests")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class StockRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private BigDecimal quantityRequested;
    private LocalDate requestDate;

    @Enumerated(EnumType.STRING)
    private Unit unit;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}


// MANY REQUESTS CAN BE OF THE SAME PRODUCT
