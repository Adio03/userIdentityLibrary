package org.semicolonlab.infrastructure.output.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.semicolonlab.domain.model.enums.ContactType;
import org.semicolonlab.domain.model.enums.Gender;
import org.semicolonlab.domain.model.enums.MfaType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Document("user_identities")
@Entity
@Table(name = "user_identities")
public class UserEntity {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private String id;

    private String firstName;

    private String lastName;

    private String middleName;

    private String dateOfBirth;

    private Gender gender;

    @Indexed(unique = true)
    @Column(unique = true)
    private String email;

    private String phoneNumber;

    private MfaType primaryMfaType;

    private boolean emailOTPEnabled;

    private boolean enabledMfaVerification;

    private boolean accountLocked; //

    private boolean emailVerified;

    private boolean enabled;

    private LocalDateTime lockExpirationTime;

    private LocalDateTime lastFailedLoginAttempt;

    private Long failedLoginAttempts;

    private String secretKey;

    private String displayPicture;

    private LocalDateTime dateCreated;

    private String timeZone;

    private LocalDateTime tokenExpirationTime;

    private boolean enabledSecurityQuestion;

    private ContactType contactType;

}
