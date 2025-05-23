package org.semicolonlab.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.semicolonlab.domain.model.enums.NameTypeConstant;
import org.semicolonlab.domain.model.messages.ErrorMessages;

import java.util.regex.Pattern;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public class NameValidatorObject {

    public static void validateName(String name, NameTypeConstant nameTypeConstant) {
        GeneralValidatorObject.validate(name, nameTypeConstant);
        boolean isNameValid;
        isNameValid = Pattern.matches("^[a-zA-Z0-9_-]*$", name);
        if (!isNameValid){
            throw new IllegalArgumentException(String.format(ErrorMessages.INVALID_FORMAT_NAME, nameTypeConstant.name().toLowerCase()));
        }
    }


}
