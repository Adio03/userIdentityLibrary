package org.semicolonlab.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.semicolonlab.domain.model.messages.ErrorMessages;
import org.semicolonlab.infrastructure.utils.PasswordValidatorObject;

class PasswordValidatorObjectTest {

    private static final String REGEX = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*()\\-_=+{};:,<.>])(?!.*['\"`])(?!.*[\\uD83C-\\uDBFF\\uDC00-\\uDFFF]).{8,32}$";

    @Test
    void nullPasswordThrows() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                PasswordValidatorObject.validatePassword(REGEX, null)
        );
        assertTrue(ex.getMessage().contains("Password"));
    }

    @Test
    void emptyPasswordThrows() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                PasswordValidatorObject.validatePassword(REGEX, "")
        );
        assertTrue(ex.getMessage().contains("Password"));
    }

    @Test
    void nullPatternThrows() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                PasswordValidatorObject.validatePassword(null, "Abcdef1!")
        );
        assertTrue(ex.getMessage().contains("Password"));
    }

    @Test
    void emptyPatternThrows() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                PasswordValidatorObject.validatePassword("", "Abcdef1!")
        );
        assertTrue(ex.getMessage().contains("Password"));
    }

    @Test
    void tooShortThrowsInvalid() {
        assertThrows(IllegalArgumentException.class, () ->
                        PasswordValidatorObject.validatePassword(REGEX, "Ab1!")
                , ErrorMessages.INVALID_PASSWORD);
    }

    @Test
    void minLengthValid() {
        assertDoesNotThrow(() ->
                PasswordValidatorObject.validatePassword(REGEX, "Abcdef1!")
        );
    }

    @Test
    void maxLengthValid() {
        String pw32 = "A1!"+ "a".repeat(29); // length = 32
        assertDoesNotThrow(() ->
                PasswordValidatorObject.validatePassword(REGEX, pw32)
        );
    }
    @Test
    void tooLongThrowsInvalid() {
        String pw33 = "A1!" + "a".repeat(30); // length = 33
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidatorObject.validatePassword(REGEX, pw33)
        );
        assertEquals(ErrorMessages.INVALID_PASSWORD, ex.getMessage());
    }

    @Test
    void missingUppercaseThrows() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidatorObject.validatePassword(REGEX, "abcdef1!")
        );
        assertEquals(ErrorMessages.INVALID_PASSWORD, ex.getMessage());
    }

    @Test
    void missingLowercaseThrows() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidatorObject.validatePassword(REGEX, "ABCDEF1!")
        );
        assertEquals(ErrorMessages.INVALID_PASSWORD, ex.getMessage());
    }

    @Test
    void missingDigitThrows() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidatorObject.validatePassword(REGEX, "Abcdefg!!")
        );
        assertEquals(ErrorMessages.INVALID_PASSWORD, ex.getMessage());
    }

    @Test
    void missingSpecialThrows() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidatorObject.validatePassword(REGEX, "Abcdef12")
        );
        assertEquals(ErrorMessages.INVALID_PASSWORD, ex.getMessage());
    }

    @Test
    void containsForbiddenSingleQuote() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidatorObject.validatePassword(REGEX, "Ab1!ab'cd")
        );
        assertEquals(ErrorMessages.INVALID_PASSWORD, ex.getMessage());
    }

    @Test
    void containsForbiddenDoubleQuote() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidatorObject.validatePassword(REGEX, "Ab1!ab\"cd")
        );
        assertEquals(ErrorMessages.INVALID_PASSWORD, ex.getMessage());
    }

    @Test
    void containsForbiddenBacktick() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidatorObject.validatePassword(REGEX, "Ab1!ab`cd")
        );
        assertEquals(ErrorMessages.INVALID_PASSWORD, ex.getMessage());
    }

    @Test
    void containsEmojiThrows() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidatorObject.validatePassword(REGEX, "Ab1!ab😊cd")
        );
        assertEquals(ErrorMessages.INVALID_PASSWORD, ex.getMessage());
    }
}
