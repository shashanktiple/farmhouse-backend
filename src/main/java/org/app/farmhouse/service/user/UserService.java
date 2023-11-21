package org.app.farmhouse.service.user;

import org.app.farmhouse.dto.user.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    /**
     * Load user by username
     * @param username
     * @return user object from database
     */
    UserDto getByUsername(String username);

    /**
     * Register new user in database
     * @param userDto
     */
    UserDto processRegistration(UserDto userDto);

    void verifyAccountEmailToken(String identifier, String token);

    void verifyAccountSMSToken(String identifier, String token);
}
