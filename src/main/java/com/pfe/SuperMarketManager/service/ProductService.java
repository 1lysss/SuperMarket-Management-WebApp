package com.pfe.SuperMarketManager.service;

import com.pfe.SuperMarketManager.Model.Product;
import com.pfe.SuperMarketManager.Model.Section;

import java.util.List;

public interface ProductService {

    long getProductCount();  // ret getQuantity

    void assignToSection(Product product, Section section);

    boolean inSection(Product product);

    // CRUD
    void addProduct(Product product);

    void removeProduct(Product product);

    void editProduct(Integer id, Product product);

    List<Product> getAllProducts();

}