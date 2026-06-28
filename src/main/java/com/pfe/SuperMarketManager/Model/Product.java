package com.pfe.SuperMarketManager.Model;

import com.pfe.SuperMarketManager.Model.Enums.Unit;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private BigDecimal unitPrice;

    @Enumerated(EnumType.STRING)
    private Unit unit;

    private LocalDate expiryDate;
    private String name;
    private BigDecimal quantity;

    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;           /* FK */

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    // One product can be in multiple sale items
    @OneToMany(mappedBy = "product")
    private List<SaleItem> saleItems;

    // One product can be requested multiple times
    @OneToMany(mappedBy = "product")
    private List<StockRequest> stockRequests;

}


