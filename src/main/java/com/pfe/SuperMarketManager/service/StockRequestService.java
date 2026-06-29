package com.pfe.SuperMarketManager.service;

import com.pfe.SuperMarketManager.Model.Enums.Status;
import com.pfe.SuperMarketManager.Model.StockRequest;
import java.util.List;

public interface StockRequestService {
    List<StockRequest> getAllRequests();
    List<StockRequest> getRequestsByStatus(Status status);
    void createRequest(StockRequest request);
    void approveRequest(Integer id);
    void rejectRequest(Integer id);

}
