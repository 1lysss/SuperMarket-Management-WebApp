package com.pfe.SuperMarketManager.Repository;

import com.pfe.SuperMarketManager.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//                                                     class/table, id type of entity
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
