package com.pfe.SuperMarketManager.Repository;

import com.pfe.SuperMarketManager.Model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer>{
    //List<Supplier> findProduct(Product product);

}
