package com.pfe.SuperMarketManager.Repository;

import com.pfe.SuperMarketManager.Model.Sale;
import com.pfe.SuperMarketManager.Model.SaleItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer> {
//    List<SaleItem> find(Sale sale); // from here we get total price by summing price for each sale items
//
}
