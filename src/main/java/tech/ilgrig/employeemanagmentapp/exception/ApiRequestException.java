package tech.ilgrig.employeemanagmentapp.exception;

import tech.ilgrig.employeemanagmentapp.utils.EmployeeAppErrorMessage;

public class ApiRequestException extends RuntimeException{
    public ApiRequestException(String message) {
        super(message);
    }

    public ApiRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
