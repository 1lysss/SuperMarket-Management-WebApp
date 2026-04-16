package com.pfe.SuperMarketManager.service.impl;

import com.pfe.SuperMarketManager.Model.Product;
import com.pfe.SuperMarketManager.Model.Section;
import com.pfe.SuperMarketManager.Repository.ProductRepository;
import com.pfe.SuperMarketManager.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public long getProductCount() {
        return productRepository.count();
    }

    @Override
    public void assignToSection(Product product, Section section) {
        product.setSection(section);
    }

    @Override
    public boolean inSection(Product product) {
        return product.getSection() != null;
    }

    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void removeProduct(Product product) {
        productRepository.delete(product);
    }

    @Override
    public void editProduct(Integer id, Product product) {
        Product existingProduct= productRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Product not found"));
        existingProduct.setName(product.getName());
        existingProduct.setSection(product.getSection());
        existingProduct.setUnitPrice(product.getUnitPrice());
        existingProduct.setExpiryDate(product.getExpiryDate());
        existingProduct.setSupplier(product.getSupplier());
        existingProduct.setSaleItems(product.getSaleItems());
        existingProduct.setStockRequests(product.getStockRequests());

        productRepository.save(existingProduct);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


}


