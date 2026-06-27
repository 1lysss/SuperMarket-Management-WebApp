package com.pfe.SuperMarketManager.converter;

import com.pfe.SuperMarketManager.Model.Supplier;
import com.pfe.SuperMarketManager.service.SupplierService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SupplierConverter implements Converter<String, Supplier> {
    private final SupplierService supplierService;
    public SupplierConverter(SupplierService supplierService) {
        this.supplierService = supplierService;
    }
    @Override
    public Supplier convert(String id) {
        return supplierService.getSupplierById(Integer.parseInt(id))
                .orElseThrow(() -> new RuntimeException("Supplier not found"));
    }
}