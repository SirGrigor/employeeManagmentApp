package tech.ilgrig.employeemanagmentapp.employees;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import tech.ilgrig.employeemanagmentapp.employees.DTO.EmployeeDTO;
import tech.ilgrig.employeemanagmentapp.utils.EmailValidator;
import tech.ilgrig.employeemanagmentapp.utils.EmployeeAppErrorMessage;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeService {
    private static EmployeeRepository employeeRepository;

    public void addEmployee(EmployeeDTO employeeDTO) {
        employeeDTO.setEmployeeCode(UUID.randomUUID().toString());
        if (employeeRepository.findEmployeeByEmail(employeeDTO.getEmail()).isPresent()) {
            throw EmployeeAppErrorMessage.error(EmployeeAppErrorMessage.Message.USER_NOT_FOUND_BY_USERNAME, employeeDTO.getEmail());
        }

        if (!EmailValidator.validateEmail(employeeDTO.getEmail())) {
            throw EmployeeAppErrorMessage.error(EmployeeAppErrorMessage.Message.USER_EMAIL_NOT_VALID_SEMANTICALLY, employeeDTO.getEmail());
        }
        employeeRepository.save(EmployeeDTO.employeeDTOToEmployee(employeeDTO));
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(EmployeeDTO employeeDTO) {
        if (!employeeRepository.existsById(employeeDTO.getId())) {
            throw EmployeeAppErrorMessage.error(EmployeeAppErrorMessage.Message.USER_WITH_USERNAME_ALREADY_EXISTS, employeeDTO.getId());
        }
        return employeeRepository.save(EmployeeDTO.employeeDTOToEmployeeAllArguments(employeeDTO));
    }

    public void deleteEmployee(EmployeeDTO employeeDTO) {
        if (!employeeRepository.existsById(employeeDTO.getId())) {
            throw EmployeeAppErrorMessage.error(EmployeeAppErrorMessage.Message.USER_WITH_USERNAME_ALREADY_EXISTS, employeeDTO.getId());
        }
        employeeRepository.deleteEmployeeById(employeeDTO.getId());
    }

    public Employee findEmployeeById(EmployeeDTO employeeDTO) {
        Optional<Employee> employeeById = employeeRepository.findEmployeeById(employeeDTO.getId());
        if (employeeById.isEmpty()) {
            throw EmployeeAppErrorMessage.error(EmployeeAppErrorMessage.Message.USER_WITH_USERNAME_ALREADY_EXISTS, employeeDTO.getId());
        }
        return employeeById.get();
    }
}
