package org.app.farmhouse.dto.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.app.farmhouse.dto.order.CartDto;
import org.app.farmhouse.dto.order.OrderDto;
import org.app.farmhouse.dto.order.SavedLaterDto;
import org.app.farmhouse.modal.user.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class UserDto implements UserDetails {

    private String username;
    private String password;
    public boolean accountVerified;
    private boolean accountNonLocked;
    private boolean accountNonExpired;
    private boolean enabled;
    private boolean credentialsNonExpired;

    public UserDto(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.accountNonExpired = user.isAccountNonExpired();
        this.accountNonLocked = user.isAccountNonLocked();
        this.enabled = user.isEnabled();
        this.credentialsNonExpired = user.isCredentialsNonExpired();
    }

    public UserDto eraseCredentials() {
        this.password = "[PROTECTED]";
        return this;
    }


    /**
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    /**
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    /**
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    /**
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    /**
     * @return
     */
    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
