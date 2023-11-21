package org.app.farmhouse.service.user;

import org.app.farmhouse.dto.user.UserDto;
import org.app.farmhouse.exception.TokenExpiredException;
import org.app.farmhouse.modal.user.AccountVerification;
import org.app.farmhouse.modal.user.User;
import org.app.farmhouse.repository.AccountVerificationRepository;
import org.app.farmhouse.repository.UserRepository;
import org.app.farmhouse.service.email.CustomEmailService;
import org.app.farmhouse.service.email.EmailTemplate;
import org.app.farmhouse.utility.ConfirmationTokenGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JPAUserDetailsService userDetailsService;

    @Autowired
    private CustomEmailService emailService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private AccountVerificationRepository verificationRepository;

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    /**
     * Load user by username
     *
     * @param username
     * @return user object from database
     */
    @Override
    public UserDto getByUsername(String username) {
        if(logger.isTraceEnabled())
            logger.trace(String.format("Loading user by username : %s", username));
        UserDto dto = (UserDto) userDetailsService.loadUserByUsername(username);
        return dto.eraseCredentials();
    }

    /**
     * Register new user in database
     *
     * @param userDto
     */
    @Override
    public UserDto processRegistration(UserDto userDto) {
        userDetailsService.createUser(userDto);
        AccountVerification verification = new AccountVerification(userDto.getUsername(), encoder.encode(userDto.getUsername()), ConfirmationTokenGenerator.getEmailConfirmationToken(userDto.getUsername()));
        verificationRepository.save(verification);
        emailService.sendMail(userDto.getUsername(), "Registration Successfully completed", EmailTemplate.generateVerificationTemplate(verification));
        return userDto.eraseCredentials();
    }

    /**
     * @param identifier
     * @param token
     */
    @Override
    public void verifyAccountEmailToken(String identifier, String token) throws TokenExpiredException{

        if(logger.isTraceEnabled()) logger.trace("Fetching Token from repository for verification.");
        Optional<AccountVerification> optional = verificationRepository.findByUserIdentifierAndExpired(identifier, false);
        AccountVerification verification = optional.orElseThrow();
        if(verification.getExpiresAt().compareTo(new Date()) < 0 && verification.getToken().equals(token)) {
            if(logger.isTraceEnabled()) logger.trace("Account verification token verified. Setting account to activated.");
            User user = userRepository.findUserByUsername(verification.getUsername()).orElseThrow();
            user.setAccountVerified(true);
            userRepository.save(user);
            verification.setExpired(true);
            verificationRepository.save(verification);
        } else {
            throw new TokenExpiredException("Verification token is expired");
        }
    }

    /**
     * @param identifier
     * @param token
     */
    @Override
    public void verifyAccountSMSToken(String identifier, String token) {

    }
}
