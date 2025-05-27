package org.semicolonlab.domain.model.enums;

import org.semicolonlab.domain.exceptions.UserIdentityException;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

public enum ContactType {

    EMAIL, PHONE;


    public static boolean isContactTypeValid(String value) {
        return Arrays.stream(((Class<? extends Enum<?>>) ContactType.class).getEnumConstants())
                .map(Enum::name)
                .anyMatch(name -> name.equalsIgnoreCase(value));
    }

    public static void validateContactType(String value) throws UserIdentityException {
        if (Arrays.stream(((Class<? extends Enum<?>>) ContactType.class).getEnumConstants())
                .map(Enum::name)
                .noneMatch(name -> name.equalsIgnoreCase(value))) {
            throw new UserIdentityException("Invalid ContactType. Allowed values: "
                    + Arrays.toString(ContactType.values()), HttpStatus.BAD_REQUEST);
        }
    }
}

