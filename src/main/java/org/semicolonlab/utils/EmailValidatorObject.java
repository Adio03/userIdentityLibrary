package org.semicolonlab.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.semicolonlab.domain.model.messages.ErrorMessages;

import java.util.regex.Pattern;
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public class EmailValidatorObject {
    private static final String emailRegex = "^[\\p{Alnum}._%+-]+@[\\p{Alnum}.+-]+\\.[A-Za-z]{2,}$";
    private static final Pattern pattern = Pattern.compile(emailRegex);

    public static void validateEmail(String email) {

        if (StringUtils.isEmpty(email.trim())) {
            log.info("Email: {} is not a valid email address.", email);
            throw new IllegalArgumentException(ErrorMessages.EMAIL_EMPTY);
        }
        if (!org.apache.commons.validator.routines.EmailValidator.getInstance().isValid(email.trim())){
            throw new IllegalArgumentException(ErrorMessages.INVALID_EMAIL_ADDRESS);
        }

        if (!pattern.matcher(email.trim()).matches()) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_EMAIL_ADDRESS);
        }
    }

    public static boolean isEmailValid(String email) {
        if (StringUtils.isEmpty(email)) {
            return false;
        }
        String trimmed = email.trim();
        if (!org.apache.commons.validator.routines.EmailValidator.getInstance().isValid(trimmed)) {
            return false;
        }
        return pattern.matcher(trimmed).matches();
    }

}
