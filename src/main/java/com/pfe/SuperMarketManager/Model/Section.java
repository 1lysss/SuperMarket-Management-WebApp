package com.pfe.SuperMarketManager.Model;
// TODO: FKs
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "sections")
@Data
@NoArgsConstructor

public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "section") // should be same as variable name at @ManyToOne in corresponding entity
    private List<Product> products;  // List of products belong to one section
}
