package org.app.farmhouse.service.user;

import jakarta.transaction.Transactional;
import org.app.farmhouse.dto.user.UserDto;
import org.app.farmhouse.modal.user.User;
import org.app.farmhouse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class JPAUserDetailsService implements UserDetailsManager {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * @param user
     */
    @Override
    public void createUser(UserDetails user) {
        User newUser = new User(user);
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        userRepository.save(newUser);
    }

    /**
     * @param user
     */
    @Override
    public void updateUser(UserDetails user) {

    }

    /**
     * @param username
     */
    @Override
    public void deleteUser(String username) {
        userRepository.deleteUserByUsername(username);
    }

    /**
     * @param oldPassword
     * @param newPassword
     */
    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }

    /**
     * @param username
     * @return
     */
    @Override
    public boolean userExists(String username) {
        return userRepository.existsByUsername(username);
    }

    /**
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findUserByUsername(username);
        User user = optionalUser.orElseThrow();
        return new UserDto(user);
    }

    public UsernamePasswordAuthenticationToken authenticate(Authentication authentication) {
        String username = authentication.getName();
        String password = String.valueOf(authentication.getCredentials());
        UserDetails user = loadUserByUsername(username);
        if(passwordEncoder.matches(password, user.getPassword())) {
            return new UsernamePasswordAuthenticationToken(username, password, user.getAuthorities());
        }
        return null;
    }


}
