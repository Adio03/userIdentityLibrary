package org.semicolonlab.infrastructure.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.semicolonlab.domain.exceptions.InvalidArgumentException;
import org.semicolonlab.domain.model.messages.ErrorMessages;

import java.util.regex.Pattern;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RegexConstants {

    public static final String PASSWORD_REGEX_PATTERN = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*()\\-_=+{};:,<.>])(?!.*['\"`])(?!.*[\\uD83C-\\uDBFF\\uDC00-\\uDFFF]).{8,32}$";

    public static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX_PATTERN);

    public static boolean isPasswordValid(String password) throws InvalidArgumentException {
        if (StringUtils.isEmpty(password)) {
            throw new InvalidArgumentException(ErrorMessages.INVALID_REQUEST);
        }
        return PASSWORD_PATTERN.matcher(password).matches();
    }
}
