package tech.ilgrig.employeemanagmentapp.employees;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Employee")
@Table(name = "employee")
public class Employee implements Serializable {
    @Id
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_sequence"
    )
    @Column(
            name = "id",
            updatable = false,
            nullable = false
    )
    private Long id;

    @Column(
            name = "first_name",
            updatable = true,
            columnDefinition = "TEXT"
    )
    private String firstName;

    @Column(
            name = "last_name",
            updatable = true,
            columnDefinition = "TEXT"
    )
    private String lastName;

    @Column(
            name = "email",
            updatable = true,
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;

    @Column(
            name = "image_url",
            updatable = true,
            columnDefinition = "TEXT"
    )
    private String imageUrl;

    @Column(
            name = "title",
            updatable = true,
            columnDefinition = "TEXT"
    )

    private String title;
    @Column(
            name = "phone",
            updatable = true,
            columnDefinition = "TEXT"
    )
    private String phone;

    @Column(
            name = "employee_code",
            updatable = false,
            nullable = false,
            columnDefinition = "TEXT"

    )
    private String employeeCode;

    public Employee(String firstName, String lastName, String email, String imageUrl, String title, String phone, String employeeCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.imageUrl = imageUrl;
        this.title = title;
        this.phone = phone;
        this.employeeCode = employeeCode;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", title='" + title + '\'' +
                ", phone='" + phone + '\'' +
                ", employeeCode='" + employeeCode + '\'' +
                '}';
    }
}
