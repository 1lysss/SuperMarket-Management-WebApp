package com.pfe.SuperMarketManager.service;

import com.pfe.SuperMarketManager.Model.Supplier;
import java.util.List;
import java.util.Optional;

public interface SupplierService {

    // CRUD

    void addSupplier(Supplier supplier);
    void deleteSupplier(Integer id);
    void updateSupplier(Supplier supplier);
    List<Supplier> getAllSuppliers();
    Optional<Supplier> getSupplierById(Integer id);
}
