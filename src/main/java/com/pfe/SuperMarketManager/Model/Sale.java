package com.pfe.SuperMarketManager.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.stream.Gatherer;

@Entity
@Table(name = "sales")
@Data
@NoArgsConstructor

public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//    private Integer cashier_id;
//    private BigDecimal totalPrice;
    private LocalDate saleDate;

}
