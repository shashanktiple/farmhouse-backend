package org.app.farmhouse.modal.user;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

@Entity(name = "authority")
@Data
@NoArgsConstructor
public class Authority implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "username")
    User user;
    private String authority;

    public Authority(String authority) {
        this.authority = authority;
    }

    public Authority withAuthority(String authority){
        this.authority = authority;
        return this;
    }
}
