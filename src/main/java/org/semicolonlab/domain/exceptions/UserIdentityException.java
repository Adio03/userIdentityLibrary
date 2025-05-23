package org.semicolonlab.domain.exceptions;
import org.springframework.http.HttpStatus;

public class UserIdentityException extends Exception {
    private HttpStatus status = HttpStatus.CONFLICT;

    public UserIdentityException(String message, HttpStatus httpStatus) {
        super(message);
        this.status = httpStatus;
    }

    public UserIdentityException(String message) {
        super(message);
    }

    public UserIdentityException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserIdentityException(String message, Throwable cause, HttpStatus status) {
        super(message, cause);
        this.status = status;
    }



    public UserIdentityException(Throwable cause) {
        super(cause);
    }

}
