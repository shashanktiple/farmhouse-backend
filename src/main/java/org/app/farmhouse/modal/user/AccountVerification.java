package org.app.farmhouse.modal.user;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity(name = "accountverification")
@Data
@NoArgsConstructor
public class AccountVerification {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String token;
    private String userIdentifier;
    private int validity = 10000;
    private Date generatedAt = new Date();
    private Date expiresAt = new Date(generatedAt.getTime() + 10000);
    private boolean expired = false;
    private String username;

    public AccountVerification(String user, String userIdentifier, String token) {
        this.username = user;
        this.userIdentifier = userIdentifier;
        this.token = token;
    }

}
