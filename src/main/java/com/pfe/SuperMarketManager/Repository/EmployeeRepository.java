package com.pfe.SuperMarketManager.Repository;

import com.pfe.SuperMarketManager.Model.Employee;
import com.pfe.SuperMarketManager.Model.Enums.Role;
import com.pfe.SuperMarketManager.Model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //Optional<Employee> findByRole(Role role);
    long countByRole(Role role);
}
