package org.semicolonlab.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.semicolonlab.domain.model.messages.ErrorMessages;

class PhoneNumberValidatorObjectTest {

    @Test
    void nullThrowsEmpty() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                PhoneNumberValidatorObject.validatePhoneNumber(null)
        );
        assertEquals("phone number cannot be null or empty", ex.getMessage());
    }

    @Test
    void emptyThrowsEmpty() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                PhoneNumberValidatorObject.validatePhoneNumber("")
        );
        assertEquals("phone number cannot be null or empty", ex.getMessage());
    }

    @Test
    void blankThrowsEmpty() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                PhoneNumberValidatorObject.validatePhoneNumber("   ")
        );
        assertEquals("phone number cannot be null or empty", ex.getMessage());
    }

    @Test
    void validStartsWith0ElevenDigits() {
        assertDoesNotThrow(() ->
                PhoneNumberValidatorObject.validatePhoneNumber("07012345678")
        );
    }

    @Test
    void validWith234Prefix() {
        assertDoesNotThrow(() ->
                PhoneNumberValidatorObject.validatePhoneNumber("2348012345678")
        );
    }

    @Test
    void validWithPlus234Prefix() {
        assertDoesNotThrow(() ->
                PhoneNumberValidatorObject.validatePhoneNumber("+2348012345678")
        );
    }

    @Test
    void invalidStartsWith06() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                PhoneNumberValidatorObject.validatePhoneNumber("0612345678")
        );
        assertEquals(ErrorMessages.INVALID_PHONE_NUMBER, ex.getMessage());
    }

    @Test
    void invalidTooShort() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                PhoneNumberValidatorObject.validatePhoneNumber("081234567")
        );
        assertEquals(ErrorMessages.INVALID_PHONE_NUMBER, ex.getMessage());
    }

    @Test
    void invalidTooLong() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                PhoneNumberValidatorObject.validatePhoneNumber("081234567890")
        );
        assertEquals(ErrorMessages.INVALID_PHONE_NUMBER, ex.getMessage());
    }

    @Test
    void invalidNonDigitChars() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                PhoneNumberValidatorObject.validatePhoneNumber("08123abc678")
        );
        assertEquals(ErrorMessages.INVALID_PHONE_NUMBER, ex.getMessage());
    }

    @Test
    void validWithSurroundingSpaces() {
        assertDoesNotThrow(() ->
                PhoneNumberValidatorObject.validatePhoneNumber(" 08123456789 ")
        );
    }
}
