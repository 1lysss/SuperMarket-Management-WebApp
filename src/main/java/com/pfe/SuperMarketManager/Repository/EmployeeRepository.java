package com.pfe.SuperMarketManager.Repository;

import com.pfe.SuperMarketManager.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

//                                                     class/table, id type of entity
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByRole(Employee.Role role);
    List<Employee> findByUsername(String userName);
}
