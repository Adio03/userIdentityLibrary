package org.semicolonlab.domain.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidArgumentException extends UserIdentityException{
    public InvalidArgumentException(String message) {
        super(message);
    }

    public InvalidArgumentException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }

    public InvalidArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidArgumentException(String message, Throwable cause, HttpStatus status) {
        super(message, cause, status);
    }

    public InvalidArgumentException(Throwable cause) {
        super(cause);
    }
}
