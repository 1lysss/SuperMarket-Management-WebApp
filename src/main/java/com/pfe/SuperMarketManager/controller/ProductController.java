package com.pfe.SuperMarketManager.controller;

import com.pfe.SuperMarketManager.Model.Product;
import com.pfe.SuperMarketManager.service.ProductService;
import com.pfe.SuperMarketManager.service.SectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.net.Inet4Address;

@Controller
@RequiredArgsConstructor
public class ProductController {

    final private ProductService productService;

    @GetMapping("/products/")
    public String showProductPage(Model model) {
        model.addAttribute("getAllProducts",  productService.getAllProducts());
        return "pages/product/products";
    }


    @GetMapping("/products/add")
    public String showAddForm(Model model) {
        model.addAttribute("product", new Product());
        return "pages/product/product_form";
    }
    @PostMapping("/products/add")
    public String  saveProduct(@ModelAttribute Product product) {
        productService.addProduct(product);
        return "redirect:/products";
    }


    @GetMapping("/products/edit/{id}")
    public String showEditForm(Model model, @PathVariable Integer id) {
        Product product = productService.getProductById(id).orElseThrow(()-> new RuntimeException("Product not found"));
        model.addAttribute("product", product);
        return "pages/product/product_form";
    }
    @PostMapping("/products/edit/{id}")
    public String updateProduct(@PathVariable Integer id, @ModelAttribute Product product) {
        Product existingProduct = productService.getProductById(id).orElseThrow(()-> new RuntimeException("Product not found"));
        existingProduct.setUnit(product.getUnit());
        existingProduct.setSection(product.getSection());
        existingProduct.setName(product.getName());
        existingProduct.setSupplier(product.getSupplier());
        existingProduct.setSaleItems(product.getSaleItems());
        existingProduct.setUnitPrice(product.getUnitPrice());
        existingProduct.setStockRequests(product.getStockRequests());
        existingProduct.setExpiryDate(product.getExpiryDate());
        productService.updateProduct(product);
        return "redirect:/products";
    }


    @PostMapping("products/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        productService.removeProduct(id);
        return "redirect:/products";
    }
}







