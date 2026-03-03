package com.pfe.SuperMarketManager.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "sales")
@Data
@NoArgsConstructor

public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private LocalDate saleDate;

    // A sale has many sale items
    @OneToMany(mappedBy = "sale")
    private List<SaleItem> saleItems;

    @ManyToOne
    @JoinColumn(name = "cashier_id")
    private Employee cashier;
}
