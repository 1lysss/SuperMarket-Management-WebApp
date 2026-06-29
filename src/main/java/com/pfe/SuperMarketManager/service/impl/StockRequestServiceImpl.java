package com.pfe.SuperMarketManager.service.impl;

import com.pfe.SuperMarketManager.Model.Enums.Status;
import com.pfe.SuperMarketManager.Model.Product;
import com.pfe.SuperMarketManager.Model.StockRequest;
import com.pfe.SuperMarketManager.Repository.ProductRepository;
import com.pfe.SuperMarketManager.Repository.StockRequestRepository;
import com.pfe.SuperMarketManager.service.StockRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor

public class StockRequestServiceImpl implements StockRequestService {

    private final StockRequestRepository stockRequestRepository;
    private final ProductRepository productRepository;

    @Override
    public List<StockRequest> getAllRequests() {
        return stockRequestRepository.findAll();
    }

    @Override
    public List<StockRequest> getRequestsByStatus(Status status) {
        return stockRequestRepository.findByStatus(status);
    }

    @Override
    public void createRequest(StockRequest request) {
        request.setStatus(Status.PENDING);
        request.setRequestDate(LocalDate.now());
        stockRequestRepository.save(request);
    }

    @Override
    public void approveRequest(Integer id) {
        StockRequest request = stockRequestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Request not found"));
        request.setStatus(Status.APPROVED);
        Product product = request.getProduct();
        product.setQuantity(product.getQuantity().add(request.getQuantityRequested()));
        productRepository.save(product);
        stockRequestRepository.save(request);
    }

    @Override
    public void rejectRequest(Integer id) {
        StockRequest request = stockRequestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Request not found"));
        request.setStatus(Status.REJECTED);
        stockRequestRepository.save(request);
    }
}
