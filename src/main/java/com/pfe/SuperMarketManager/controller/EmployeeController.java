package com.pfe.SuperMarketManager.controller;

import com.pfe.SuperMarketManager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/* Create method handler for some page "page.html" to display list of employees */


@RestController

public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    // Show list of employees
    //@GetMapping("/")
    public String viewHomePage(Model model){
        // Assign retval to use in thymeleaf
        model.addAttribute("getAllEmployees", employeeService.getAllEmployees());
        return "index";  // html page
    }
}


