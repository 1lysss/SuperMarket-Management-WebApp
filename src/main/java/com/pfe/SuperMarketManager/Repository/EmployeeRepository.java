package com.pfe.SuperMarketManager.Repository;

import com.pfe.SuperMarketManager.Model.Employee;
import com.pfe.SuperMarketManager.Model.Enums.Role;
import org.hibernate.metamodel.internal.EmbeddableInstantiatorPojoIndirecting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //Optional<Employee> findByUsername(String username);
    Optional<Employee> findById(int id);
    long countByRole(Role role);
    void deleteById(Integer id);
}
