package com.pfe.SuperMarketManager.controller;

import com.pfe.SuperMarketManager.Model.Supplier;
import com.pfe.SuperMarketManager.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class    SupplierController {

    final private SupplierService supplierService;

    @GetMapping("/suppliers/")
    public String showSuppliers(Model model) {
        model.addAttribute("getAllSuppliers", supplierService.getAllSuppliers());
        return "pages/supplier/suppliers";
    }

    @GetMapping("/suppliers/add")
    public String showAddForm(Model model) {
        model.addAttribute("supplier", new Supplier());
        return "pages/supplier/supplier_form";
    }

    @PostMapping("/suppliers/add")
    public String saveSupplier(@ModelAttribute Supplier supplier) {
        supplierService.addSupplier(supplier);
        return "redirect:/suppliers/";
    }

    @GetMapping("/suppliers/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Supplier supplier = supplierService.getSupplierById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found"));
        model.addAttribute("supplier", supplier);
        return "pages/supplier/supplier_form";
    }

    @PostMapping("/suppliers/edit/{id}")
    public String updateSupplier(@PathVariable Integer id, @ModelAttribute Supplier supplier) {
        Supplier existing = supplierService.getSupplierById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found"));
        existing.setName(supplier.getName());
        existing.setPhone(supplier.getPhone());
        existing.setEmail(supplier.getEmail());
        existing.setAddress(supplier.getAddress());
        supplierService.updateSupplier(existing);
        return "redirect:/suppliers/";
    }

    @PostMapping("/suppliers/delete/{id}")
    public String deleteSupplier(@PathVariable Integer id) {
        supplierService.deleteSupplier(id);
        return "redirect:/suppliers/";
    }
}
