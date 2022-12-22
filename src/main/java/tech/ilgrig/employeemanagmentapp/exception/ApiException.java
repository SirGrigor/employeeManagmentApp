package tech.ilgrig.employeemanagmentapp.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Getter
public class ApiException {
    private final String message;
    private final HttpStatus httpStatus;

    public ApiException(String message,
                        HttpStatus httpStatus,
                        ZonedDateTime timestamp) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.timestamp = timestamp;
    }

    private final ZonedDateTime timestamp;
}
