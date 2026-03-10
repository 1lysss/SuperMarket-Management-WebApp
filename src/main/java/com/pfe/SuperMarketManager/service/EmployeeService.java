package com.pfe.SuperMarketManager.service;

import com.pfe.SuperMarketManager.Model.Employee;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    long getAdminCount();
    long getStockManagerCount();
    long getCashierCount();

    // CRUD operations:
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
    void deleteEmployee(Integer id);
    void updateEmployee(Employee employee);
    Employee getEmployeeById(Integer id);
}
