package com.pfe.SuperMarketManager.Repository;

import com.pfe.SuperMarketManager.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository         //class/table, id type of entity
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByRole(Employee.Role role);
    List<Employee> findByUsername(String userName);
}
