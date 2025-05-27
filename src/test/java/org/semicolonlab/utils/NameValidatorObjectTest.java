package org.semicolonlab.utils;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.semicolonlab.domain.model.enums.NameTypeConstant;
import org.semicolonlab.infrastructure.utils.NameValidatorObject;


class NameValidatorObjectTest {

    @Test void validSimpleLetters() {
        assertDoesNotThrow(() ->
                NameValidatorObject.validateName("Alice", NameTypeConstant.FIRST_NAME)
        );
    }

    @Test void validLettersAndDigits() {
        assertDoesNotThrow(() ->
                NameValidatorObject.validateName("User123", NameTypeConstant.LAST_NAME)
        );
    }

    @Test void validUnderscoresAndHyphens() {
        assertDoesNotThrow(() ->
                NameValidatorObject.validateName("john_doe-99", NameTypeConstant.MIDDLE_NAME)
        );
    }

    @Test void emptyNameThrows() {
        assertThrows(IllegalArgumentException.class, () ->
                NameValidatorObject.validateName("", NameTypeConstant.FIRST_NAME)
        );
    }

    @Test void nullNameThrows() {
        assertThrows(IllegalArgumentException.class, () ->
                NameValidatorObject.validateName(null, NameTypeConstant.LAST_NAME)
        );
    }

    @Test void nameWithInternalSpaceThrows() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                NameValidatorObject.validateName("Mary Jane", NameTypeConstant.FIRST_NAME)
        );
        assertTrue(
                ex.getMessage().contains(NameTypeConstant.FIRST_NAME.name().toLowerCase()),
                "Expected message to mention the field name"
        );

    }

    @Test void nameWithApostropheThrows() {
        assertThrows(IllegalArgumentException.class, () ->
                NameValidatorObject.validateName("O'Connor", NameTypeConstant.LAST_NAME)
        );
    }

    @Test void nameWithAccentedLettersThrows() {
        assertThrows(IllegalArgumentException.class, () ->
                NameValidatorObject.validateName("José", NameTypeConstant.FIRST_NAME)
        );
    }

    @Test void nameWithEmojiThrows() {
        assertThrows(IllegalArgumentException.class, () ->
                NameValidatorObject.validateName("Anna😊", NameTypeConstant.FIRST_NAME)
        );
    }
}
