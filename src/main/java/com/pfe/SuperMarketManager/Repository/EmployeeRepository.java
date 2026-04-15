package com.pfe.SuperMarketManager.Repository;

import com.pfe.SuperMarketManager.Model.Employee;
import com.pfe.SuperMarketManager.Model.Enums.Role;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.NullMarked;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Optional<Employee> findById(int id);
    long countByRole(Role role);
    void deleteById(@NonNull Integer id);
    @NullMarked List<Employee> findAll();
    long countAllProducts();
}
