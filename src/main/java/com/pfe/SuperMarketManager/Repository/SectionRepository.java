package com.pfe.SuperMarketManager.Repository;

import com.pfe.SuperMarketManager.Model.Product;
import com.pfe.SuperMarketManager.Model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SectionRepository extends JpaRepository<Section, Integer> {
    Section findByName(String name);
}
