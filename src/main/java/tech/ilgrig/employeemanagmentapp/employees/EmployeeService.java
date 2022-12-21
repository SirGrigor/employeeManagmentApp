package tech.ilgrig.employeemanagmentapp.employees;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.ilgrig.employeemanagmentapp.utils.EmailValidator;
import tech.ilgrig.employeemanagmentapp.utils.EmployeeAppErrorMessage;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        if (employeeRepository.findEmployeeByEmail(employee.getEmail()).isPresent()) {
            throw EmployeeAppErrorMessage.error(EmployeeAppErrorMessage.Message.USER_NOT_FOUND_BY_USERNAME, employee.getEmail());
        }

        if (!EmailValidator.validateEmail(employee.getEmail())) {
            throw EmployeeAppErrorMessage.error(EmployeeAppErrorMessage.Message.USER_EMAIL_NOT_VALID_SEMANTICALLY, employee.getEmail());
        }
        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        if (!employeeRepository.existsById(employee.getId())) {
            throw EmployeeAppErrorMessage.error(EmployeeAppErrorMessage.Message.USER_WITH_USERNAME_ALREADY_EXISTS, employee.getId());
        }
        return employeeRepository.save(employee);
    }

    public Employee deleteEmployee(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw EmployeeAppErrorMessage.error(EmployeeAppErrorMessage.Message.USER_WITH_USERNAME_ALREADY_EXISTS, id);
        }
        return employeeRepository.deleteEmployeeById(id);
    }

    public Employee findEmployeeById(Long id) {
        Optional<Employee> employeeById = employeeRepository.findEmployeeById(id);
        if (employeeById.isEmpty()) {
            throw EmployeeAppErrorMessage.error(EmployeeAppErrorMessage.Message.USER_WITH_USERNAME_ALREADY_EXISTS, id);
        }
        return employeeById.get();
    }
}
