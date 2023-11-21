package org.app.farmhouse.controller;

import org.app.farmhouse.dto.user.UserDto;
import org.app.farmhouse.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/authenticate/login")
    public ResponseEntity<UserDto> loginUser(@RequestParam String username){
        userService.getByUsername(username);
        return null;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto){
        userService.processRegistration(userDto);
        return ResponseEntity.ok(userDto.eraseCredentials());
    }

    @GetMapping("/account/verification")
    public String verifyAccount(@RequestParam String identifier, @RequestParam String confirmationtoken){
        userService.verifyAccountEmailToken(identifier, confirmationtoken);
        return "Account Verified";
    }

}
