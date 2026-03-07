package com.pfe.SuperMarketManager.service.impl;

import com.pfe.SuperMarketManager.Model.Employee;
import com.pfe.SuperMarketManager.Model.Enums.Role;
import com.pfe.SuperMarketManager.Model.Sale;
import com.pfe.SuperMarketManager.Repository.EmployeeRepository;
import com.pfe.SuperMarketManager.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;


    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public long getAdminCount() {
        return employeeRepository.countByRole(Role.ADMIN);
    }

    @Override
    public long getStockManagerCount() {
        return employeeRepository.countByRole(Role.STOCK_MANAGER);
    }

    @Override
    public long getCashierCount() {
        return employeeRepository.countByRole(Role.CASHIER);
    }
}
