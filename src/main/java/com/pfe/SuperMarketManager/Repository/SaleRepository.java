package com.pfe.SuperMarketManager.Repository;

import com.pfe.SuperMarketManager.Model.Sale;
import com.pfe.SuperMarketManager.Model.SaleItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Integer> {
    List<SaleItem> findSale(Sale sale); // from here we get total price by summing price for each sale items

}
