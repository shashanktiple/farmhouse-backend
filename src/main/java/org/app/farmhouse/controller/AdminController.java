package org.app.farmhouse.controller;

import org.app.farmhouse.dto.user.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {


    @GetMapping("/authenticate")
    public ResponseEntity<UserDto> adminLogin(){
        return null;
    }

}
