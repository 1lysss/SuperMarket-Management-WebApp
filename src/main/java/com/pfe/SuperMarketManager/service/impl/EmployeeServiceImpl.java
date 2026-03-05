package com.pfe.SuperMarketManager.service.impl;

import com.pfe.SuperMarketManager.Model.Employee;
import com.pfe.SuperMarketManager.Repository.EmployeeRepository;
import com.pfe.SuperMarketManager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Integer getEmployeeId() {
        return 0;
    }
}
