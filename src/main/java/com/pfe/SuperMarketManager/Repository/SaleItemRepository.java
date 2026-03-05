package com.pfe.SuperMarketManager.Repository;

import com.pfe.SuperMarketManager.Model.SaleItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleItemRepository extends JpaRepository<SaleItem, Integer> {

}
