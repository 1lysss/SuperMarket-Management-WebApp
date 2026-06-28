package com.pfe.SuperMarketManager.Repository;

import com.pfe.SuperMarketManager.Model.Product;
import com.pfe.SuperMarketManager.Model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findBySection(Section section);
    List<Product> findBySectionId(Integer sectionId);
    Product findByName(Product product);
    long count();
}


// methods specific to your database are the ones needed to be declared here!!!
