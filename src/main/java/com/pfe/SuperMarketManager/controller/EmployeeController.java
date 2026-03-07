package com.pfe.SuperMarketManager.controller;

import com.pfe.SuperMarketManager.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class EmployeeController {

    final private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String viewHomePage(Model model){
        // Assign retval to use in thymeleaf
        model.addAttribute("getAllEmployees",      employeeService.getAllEmployees());
        model.addAttribute("getAdminCount",        employeeService.getAdminCount());
        model.addAttribute("getStockManagerCount", employeeService.getStockManagerCount());
        model.addAttribute("getCashierCount",      employeeService.getCashierCount());

        return "index";
    }
}


