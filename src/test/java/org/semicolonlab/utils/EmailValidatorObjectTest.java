package org.semicolonlab.utils;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.semicolonlab.domain.model.messages.ErrorMessages;

class EmailValidatorObjectTest {

    @Test
    void emptyEmailThrowsEmpty() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                EmailValidatorObject.validateEmail("")
        );
        assertEquals(ErrorMessages.EMAIL_EMPTY, ex.getMessage());
    }

    @Test
    void missingAtSymbolThrowsInvalid() {
        assertThrows(IllegalArgumentException.class, () ->
                EmailValidatorObject.validateEmail("userexample.com")
        );
        assertFalse(EmailValidatorObject.isEmailValid("userexample.com"));
    }

    @Test
    void missingLocalPartThrowsInvalid() {
        assertThrows(IllegalArgumentException.class, () ->
                EmailValidatorObject.validateEmail("@example.com")
        );
        assertFalse(EmailValidatorObject.isEmailValid("@example.com"));
    }

    @Test
    void missingDomainThrowsInvalid() {
        assertThrows(IllegalArgumentException.class, () ->
                EmailValidatorObject.validateEmail("user@")
        );
        assertFalse(EmailValidatorObject.isEmailValid("user@"));
    }

    @Test
    void missingTldThrowsInvalid() {
        String email = "user@example";
        assertThrows(IllegalArgumentException.class, () ->
                EmailValidatorObject.validateEmail(email)
        );
        assertFalse(EmailValidatorObject.isEmailValid(email));
    }

    @Test
    void invalidCharsInLocalThrowsInvalid() {
        assertThrows(IllegalArgumentException.class, () ->
                EmailValidatorObject.validateEmail("us er@example.com")
        );
        assertFalse(EmailValidatorObject.isEmailValid("us er@example.com"));
    }

    @Test
    void consecutiveDotsInDomainThrowsInvalid() {
        String email = "user@exa..mple.com";
        assertThrows(IllegalArgumentException.class, () ->
                EmailValidatorObject.validateEmail(email)
        );
        assertFalse(EmailValidatorObject.isEmailValid(email));
    }

    @Test
    void validSimpleEmail() {
        assertDoesNotThrow(() ->
                EmailValidatorObject.validateEmail("alice@example.com")
        );
        assertTrue(EmailValidatorObject.isEmailValid("alice@example.com"));
    }

    @Test
    void validComplexEmail() {
        String email = "first.last+tag@sub.domain.co.uk";
        assertDoesNotThrow(() ->
                EmailValidatorObject.validateEmail(email)
        );
        assertTrue(EmailValidatorObject.isEmailValid(email));
    }

    @Test
    void uppercaseEmailIsValid() {
        String email = "USER@EXAMPLE.COM";
        assertDoesNotThrow(() ->
                EmailValidatorObject.validateEmail(email)
        );
        assertTrue(EmailValidatorObject.isEmailValid(email));
    }

    @Test
    void emailWithSpacesIsTrimmedAndValid() {
        String email = "  bob@example.com  ";
        assertDoesNotThrow(() ->
                EmailValidatorObject.validateEmail(email)
        );
        assertTrue(EmailValidatorObject.isEmailValid(email.trim()));
    }

    @Test
    void tooShortTldThrowsInvalid() {
        String email = "user@domain.c";
        assertThrows(IllegalArgumentException.class, () ->
                EmailValidatorObject.validateEmail(email)
        );
        assertFalse(EmailValidatorObject.isEmailValid(email));
    }
}
