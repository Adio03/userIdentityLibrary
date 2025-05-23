package org.semicolonlab.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.semicolonlab.domain.model.enums.NameTypeConstant;
import org.semicolonlab.domain.model.messages.ErrorMessages;
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public class GeneralValidatorObject {

    public static void validate(String name, NameTypeConstant constant)  {
        if (StringUtils.isEmpty(name) || StringUtils.isBlank(name) || StringUtils.isEmpty(name.trim()) || name.equals(ErrorMessages.UNDEFINED)) {
            log.info("validation password ======>>> {}", name);
            throw new IllegalArgumentException(String.format(ErrorMessages.CANNOT_BE_EMPTY_OR_NULL,constant));
        }
    }
}
