package com.pfe.SuperMarketManager.Repository;

import com.pfe.SuperMarketManager.Model.StockRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StockRequestRepository extends JpaRepository<StockRequest, Integer> {
    // find requests with a certain stat
    List<StockRequest> findByStatus(StockRequest.Status status);
}
