package com.pfe.SuperMarketManager.controller;

import com.pfe.SuperMarketManager.Model.Product;
import com.pfe.SuperMarketManager.service.ProductService;
import com.pfe.SuperMarketManager.service.SectionService;
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
public class ProductController {

    final private ProductService productService;
    final private SectionService sectionService;
    final private SupplierService supplierService;

    @GetMapping("/products/")
    public String showProductPage(Model model) {
        model.addAttribute("getAllProducts", productService.getAllProducts());
        return "pages/product/products";
    }

    @GetMapping("/products/add")
    public String showAddForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("getAllSections", sectionService.getAllSections());
        model.addAttribute("getAllSuppliers", supplierService.getAllSuppliers());
        return "pages/product/product_form";
    }

    @PostMapping("/products/add")
    public String saveProduct(@ModelAttribute Product product) {
        productService.addProduct(product);
        return "redirect:/products/";
    }

    @GetMapping("/products/edit/{id}")
    public String showEditForm(Model model, @PathVariable Integer id) {
        Product product = productService.getProductById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        model.addAttribute("product", product);
        model.addAttribute("getAllSections", sectionService.getAllSections());
        model.addAttribute("getAllSuppliers", supplierService.getAllSuppliers());
        return "pages/product/product_form";
    }

    @PostMapping("/products/edit/{id}")
    public String updateProduct(@PathVariable Integer id, @ModelAttribute Product product) {
        Product existingProduct = productService.getProductById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        existingProduct.setName(product.getName());
        existingProduct.setUnitPrice(product.getUnitPrice());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setUnit(product.getUnit());
        existingProduct.setSection(product.getSection());
        existingProduct.setSupplier(product.getSupplier());
        existingProduct.setExpiryDate(product.getExpiryDate());
        productService.updateProduct(existingProduct);
        return "redirect:/products/";
    }

    @PostMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        productService.removeProduct(id);
        return "redirect:/products/";
    }

    @GetMapping("/products/bySection/{sectionId}")
    public String showProductsBySection(@PathVariable Integer sectionId, Model model) {
        model.addAttribute("getAllProducts", productService.getProductsBySection(sectionId));
        return "pages/product/products";
    }
}





