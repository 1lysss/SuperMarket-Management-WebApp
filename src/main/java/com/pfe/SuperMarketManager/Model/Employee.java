package com.pfe.SuperMarketManager.Model;

import com.pfe.SuperMarketManager.Model.Enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employees") // specify table name in database
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    @Id // Indicate primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // Indicate auto increment
    private Integer id;

    @Column(nullable = false)
    private String fullName;

    @Column(unique = true, nullable = false)
    private String username;

    private String password;
    private String email;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(updatable = false)
    private LocalDate createdAt;

    @OneToMany(mappedBy = "cashier")
    private List<Sale> sales;

}



