package com.pfe.SuperMarketManager.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "employees") // specify table name in database
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    public enum Role {
        ADMIN, STOCK_MANAGER, CASHIER
    }

    @Id // Indicate primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // Indicate auto increment
    private Integer id;

    private String fullName;

    @Column(
            unique = true,
            nullable = false
    )
    private String username;

    private String password;
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(updatable = false)
    private LocalDate createdAt;
}



