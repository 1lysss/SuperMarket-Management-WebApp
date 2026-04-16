package com.pfe.SuperMarketManager.service.impl;

import com.pfe.SuperMarketManager.Model.Employee;
import com.pfe.SuperMarketManager.Model.Enums.Role;
import com.pfe.SuperMarketManager.Repository.EmployeeRepository;
import com.pfe.SuperMarketManager.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;


@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found getEmployeeById()"));
    }

    @Override
    public void saveEmployee(Employee employee) {
        if (employee.getPassword() != null ) {
            employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        }
        employee.setCreatedAt(LocalDate.now());
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        Employee existingEmployee = employeeRepository.findById(employee.getId())
                .orElseThrow(()-> new RuntimeException("Employee not found updateEmployee()"));
        // TODO : Finish updateEmployee()
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
