package org.semicolonlab.infrastructure.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.semicolonlab.domain.model.messages.ErrorMessages;

import java.util.regex.Pattern;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PhoneNumberValidatorObject {

    private static final String PHONE_NUMBER_PATTERN="^(?:0|234|\\+234)?[7-9]\\d{9}$";


    public static void validatePhoneNumber(String phoneNumber) {
        if(phoneNumber != null) {
            phoneNumber = phoneNumber.trim();
        }
        if (StringUtils.isEmpty(phoneNumber) || StringUtils.isBlank(phoneNumber)) {
            throw new IllegalArgumentException("phone number cannot be null or empty");
        }

        if( !Pattern.compile(PHONE_NUMBER_PATTERN).matcher(phoneNumber).matches()) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_PHONE_NUMBER);
        }
    }
    public static boolean isPhoneNumberValid(String phoneNumber){
        return Pattern.compile(PHONE_NUMBER_PATTERN).matcher(phoneNumber).matches();
    }
}
