package org.semicolonlab.domain.model.identity;

import lombok.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.semicolonlab.domain.model.enums.NameTypeConstant;
import org.semicolonlab.utils.*;

import java.time.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
@Slf4j
public class UserIdentity{
    private String id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String middleName;
    private String phoneNumber;
    private String newPassword;
    private LocalDate dateOfBirth;
    private boolean emailVerified;
    private boolean enabled;
    private boolean accountLocked;
    private String displayPicture;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXXXX'['VV']'")
    private ZonedDateTime lockExpirationTime;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXXXX'['VV']'")
    private ZonedDateTime lastFailedLoginAttempt;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXXXX'['VV']'")
    private ZonedDateTime dateCreated;
    private boolean emailOTPEnabled;
    private boolean enabledMfaVerification;
    private Long failedLoginAttempts;
    private String secretKey;
    private String accessToken;
    private String refreshToken;
    private String bvn;
    private String nin;
    private String keycloakClientId;
    private LocalDateTime tokenExpirationTime;
    private boolean enabledSecurityQuestion;
    private String passportNumber;
    private boolean kycComplete;

    public UserIdentity(String email, String password) {
        this.email = email.trim();
        this.password = password;
    }
    public void setEmail(String email) {
        EmailValidatorObject.validateEmail(email);
        this.email = email.trim().toLowerCase();
    }

    public void setPassword(String password) {
        log.info("Password to be set: {}",password);
        PasswordValidatorObject.validatePassword(RegexConstants.PASSWORD_REGEX_PATTERN, password);
        this.password = password.trim();
    }

    public void setFirstName(String firstName) {
        NameValidatorObject.validateName(firstName, NameTypeConstant.FIRST_NAME);
        this.firstName = firstName.trim();
    }

    public void setLastName(String lastName) {
        NameValidatorObject.validateName(lastName,NameTypeConstant.LAST_NAME);
        this.lastName = lastName.trim();
    }

    public void setMiddleName(String middleName) {
        NameValidatorObject.validateName(middleName,NameTypeConstant.MIDDLE_NAME);
        this.middleName = middleName.trim();
    }

    public void setNewPassword(String newPassword) {
        PasswordValidatorObject.validatePassword(RegexConstants.PASSWORD_REGEX_PATTERN, newPassword);
        this.newPassword = newPassword.trim();
    }

    public void setPhoneNumber(String phoneNumber) {
        if(StringUtils.isNotEmpty(phoneNumber) && StringUtils.isNotBlank(phoneNumber)) {
            phoneNumber= phoneNumber.trim();
        }
        PhoneNumberValidatorObject.validatePhoneNumber(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    public void setAccessToken(String accessToken) {
        GeneralValidatorObject.validate(accessToken, NameTypeConstant.ACCESS_TOKEN);
        this.accessToken = accessToken;
    }



    public boolean isActive () {
        return this.emailVerified && this.enabled;
    }

    public boolean isMfaEnabled() {
        return this.emailOTPEnabled || this.enabledMfaVerification;
    }



}