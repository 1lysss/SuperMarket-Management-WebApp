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

//    @Override
//    public void assignToSection(Product product, Section section) {
//        product.setSection(section);
//    }
//
//    @Override
//    public boolean inSection(Product product) {
//        return product.getSection() != null;
//    }

    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void removeProduct(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(Integer id) {
        return productRepository.findById(id);
    }


}


