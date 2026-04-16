package com.pfe.SuperMarketManager.controller;

import com.pfe.SuperMarketManager.Model.Product;
import com.pfe.SuperMarketManager.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    final private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // ========================= GET MAPPINGS  ========================= \\

    @GetMapping("/admin/products")
    public String showProductPage(Model model) {
        model.addAttribute("getProductCount", productService.getProductCount());
        model.addAttribute("getAllProducts",  productService.getAllProducts());

        return "pages/product/index";
    }

}
