package tech.ilgrig.employeemanagmentapp.employees;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findEmployeeById(Long id);
    Optional<Employee> deleteEmployeeById(Long id);
    Optional<Employee> findEmployeeByEmail(String email);
}
