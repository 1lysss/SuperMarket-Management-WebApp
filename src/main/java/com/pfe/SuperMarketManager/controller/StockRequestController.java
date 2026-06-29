package com.pfe.SuperMarketManager.controller;

import com.pfe.SuperMarketManager.Model.Enums.Status;
import com.pfe.SuperMarketManager.Model.StockRequest;
import com.pfe.SuperMarketManager.service.ProductService;
import com.pfe.SuperMarketManager.service.StockRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class StockRequestController {

    private final StockRequestService stockRequestService;
    private final ProductService productService;

    // ── ADMIN ──────────────────────────────
    @GetMapping("/admin/stock_requests")
    public String adminViewRequests(Model model) {
        model.addAttribute("requests", stockRequestService.getRequestsByStatus(Status.PENDING));
        return "pages/stock_req/requests";
    }

    @PostMapping("/admin/stock_requests/approve/{id}")
    public String approveRequest(@PathVariable Integer id) {
        stockRequestService.approveRequest(id);
        return "redirect:/admin/stock_requests";
    }

    @PostMapping("/admin/stock_requests/reject/{id}")
    public String rejectRequest(@PathVariable Integer id) {
        stockRequestService.rejectRequest(id);
        return "redirect:/admin/stock_requests";
    }

    // ── STOCK MANAGER ──────────────────────
    @GetMapping("/stock/requests")
    public String managerViewRequests(Model model) {
        model.addAttribute("requests", stockRequestService.getAllRequests());
        return "pages/stock_req/requests";
    }

    @GetMapping("/stock/requests/new")
    public String showRequestForm(Model model) {
        model.addAttribute("request", new StockRequest());
        model.addAttribute("products", productService.getAllProducts());
        return "pages/stock_req/request_form";
    }

    @PostMapping("/stock/requests/new")
    public String saveRequest(@ModelAttribute("request") StockRequest request) {
        stockRequestService.createRequest(request);
        return "redirect:/stock/requests";
    }
}