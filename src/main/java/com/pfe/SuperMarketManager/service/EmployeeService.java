package com.pfe.SuperMarketManager.service;

import com.pfe.SuperMarketManager.Model.Employee;
import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Integer getEmployeeId();

}
