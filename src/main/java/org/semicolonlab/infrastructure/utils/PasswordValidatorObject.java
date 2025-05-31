package org.semicolonlab.infrastructure.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.semicolonlab.domain.model.messages.ErrorMessages;


import java.util.regex.Pattern;
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public class PasswordValidatorObject {

    public static void validatePassword(String passwordPattern, String password) {
        if (StringUtils.isEmpty(passwordPattern) || StringUtils.isEmpty(password)) {

            throw new IllegalArgumentException(String.format(ErrorMessages.CANNOT_BE_EMPTY_OR_NULL, "Password"));
        }
        Pattern pattern = Pattern.compile(passwordPattern);
        if (!pattern.matcher(password).matches()) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_PASSWORD);
        }
    }
}
