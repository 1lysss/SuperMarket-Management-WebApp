package com.pfe.SuperMarketManager.service;

import com.pfe.SuperMarketManager.Model.Product;
import com.pfe.SuperMarketManager.Model.Section;
import java.util.List;
import java.util.Optional;

public interface ProductService {

//    long getProductCount();  // ret getQuantity
//    void assignToSection(Product product, Section section);
//    boolean inSection(Product product);

    // CRUD
    void addProduct(Product product);
    void removeProduct(Integer id);
    void updateProduct(Product product);
    List<Product> getAllProducts();
    Optional<Product> getProductById(Integer id);


    List<Product> getProductsBySection(Integer sectionId);
}