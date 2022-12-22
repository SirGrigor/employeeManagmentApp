package tech.ilgrig.employeemanagmentapp.employees;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.ilgrig.employeemanagmentapp.exception.ApiRequestException;
import tech.ilgrig.employeemanagmentapp.utils.EmailValidator;
import tech.ilgrig.employeemanagmentapp.utils.EmployeeAppErrorMessage;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static tech.ilgrig.employeemanagmentapp.utils.EmployeeAppErrorMessage.Message.*;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        if (employeeRepository.findEmployeeByEmail(employee.getEmail()).isPresent()) {
            throw new ApiRequestException(EmployeeAppErrorMessage.getMessage(USER_NOT_FOUND_BY_USERNAME, employee.getEmail()));
        }

        if (!EmailValidator.validateEmail(employee.getEmail())) {
            throw new ApiRequestException(EmployeeAppErrorMessage.getMessage(USER_EMAIL_NOT_VALID_SEMANTICALLY, employee.getEmail()));
        }
        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        if (!employeeRepository.existsById(employee.getId())) {
            throw new ApiRequestException(EmployeeAppErrorMessage.getMessage(USER_WITH_USERNAME_ALREADY_EXISTS, employee.getId()));
        }
        return employeeRepository.save(employee);
    }

    public Employee deleteEmployee(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new ApiRequestException(EmployeeAppErrorMessage.getMessage(USER_WITH_USERNAME_ALREADY_EXISTS, id));
        }
        return employeeRepository.deleteEmployeeById(id);
    }

    public Employee findEmployeeById(Long id) {
        Optional<Employee> employeeById = employeeRepository.findEmployeeById(id);
        if (employeeById.isEmpty()) {
            throw new ApiRequestException(EmployeeAppErrorMessage.getMessage(USER_WITH_USERNAME_ALREADY_EXISTS, id));
        }
        return employeeById.get();
    }
}
