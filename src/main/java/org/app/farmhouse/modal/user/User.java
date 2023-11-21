package org.app.farmhouse.modal.user;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.app.farmhouse.constants.AuthorityEnum;
import org.app.farmhouse.constants.Role;
import org.app.farmhouse.dto.user.UserDto;
import org.app.farmhouse.modal.order.Cart;
import org.app.farmhouse.modal.order.Order;
import org.app.farmhouse.modal.order.SavedLater;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity(name = "users")
@Data
@NoArgsConstructor
public class User {

    @Id
    @Column(length = 100)
    private String username;
    private String password;
    private boolean accountVerified = false;
    private boolean accountNonLocked = true;
    private boolean accountNonExpired = true;
    private boolean enabled = true;
    private boolean credentialsNonExpired = true;
    private Date created = new Date();
    private Date lastSaved = new Date();
    private String role = Role.USER.name();
//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
//    @PrimaryKeyJoinColumn
//    private UserInfo userInfo;
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<Order> orders;
//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//    private List<Address> address = new ArrayList<>();
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<Cart> carts;
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<SavedLater> savedLater;
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<Authority> authorities = List.of(new Authority("read"));

    public User(UserDetails userDto) {
        this.username = userDto.getUsername();
        this.password = userDto.getPassword();
    }
}
