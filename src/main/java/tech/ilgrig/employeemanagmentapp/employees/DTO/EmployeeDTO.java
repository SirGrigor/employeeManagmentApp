package tech.ilgrig.employeemanagmentapp.employees.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.ilgrig.employeemanagmentapp.employees.Employee;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String imageUrl;
    private String title;
    private String phone;
    private String employeeCode;

    public static Employee employeeDTOToEmployee(EmployeeDTO employeeDTO) {
        return new Employee(
                employeeDTO.getLastName(),
                employeeDTO.getFirstName(),
                employeeDTO.getTitle(),
                employeeDTO.getImageUrl(),
                employeeDTO.getEmployeeCode(),
                employeeDTO.getPhone(),
                employeeDTO.getEmail()
        );
    }

    public static Employee employeeDTOToEmployeeAllArguments(EmployeeDTO employeeDTO) {
        return new Employee(
                employeeDTO.getId(),
                employeeDTO.getLastName(),
                employeeDTO.getFirstName(),
                employeeDTO.getTitle(),
                employeeDTO.getImageUrl(),
                employeeDTO.getEmployeeCode(),
                employeeDTO.getPhone(),
                employeeDTO.getEmail()
        );
    }
}
