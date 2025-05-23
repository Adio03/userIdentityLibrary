package org.semicolonlab.domain.model.messages;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.objenesis.instantiator.sun.SunReflectionFactoryInstantiator;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class  ErrorMessages {

    public static final String ERROR_LOG = "Error logging ========>>>>>";

    public static final String UNDEFINED = "undefined";

    public static final String THIS_FIELD_IS_REQUIRED = "This field is required";


    public static final String INVALID_PHONE_NUMBER = "Please enter a valid phone number";

    public static final String REQUIRED_FIELD_IS_EMPTY = "Required field is empty";

    public static final String INVALID_PASSWORD = "Password validation failed because, password must contain 8 to 32 characters long and include at least one uppercase letter, one lowercase letter, and one numeric digit";

    public static final String CANT_BE_NULL_OR_EMPTY = "Id or emailOrPhoneNumber cant be null or empty";

    public static final String EMAIL_EMPTY = "Email field cannot be empty";

    public static final String PHONE_NUMBER_EMPTY = "Phone number cannot be empty";
    public static final String INVALID_FORMAT_NAME = "%s can only contain alphabetic, alphanumeric characters and hyphen and can have a maximum of 3 characters and a minimum of 1024 characters";
    public static final String REQUIRED_FIELD_IS_NULL = "Required field is missing";

    public static final String USER_ID_CANNOT_BE_BLANK_OR_NULL = "User ID cannot be Blank,Empty or Null.";

    public static final String USER_ID_CANNOT_BE_INVALID = "UserId is required.";

    public static final String INVALID_ID_TYPE = "Invalid id type";

    public static final String CANNOT_BE_EMPTY_OR_NULL = " %s cannot be empty or null";
    public static final String INVALID_EMAIL_ADDRESS = "Invalid email address";
    public static final String INVALID_REQUEST = "Invalid request";
}