package org.app.farmhouse.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.app.farmhouse.dto.user.UserDto;
import org.app.farmhouse.service.user.JPAUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login/oauth2")
public class OauthLoginController {

    @Autowired
    private JPAUserDetailsService service;

    @GetMapping("/process")
    public ResponseEntity<UserDto> processLogin(@Validated Model model, Authentication authentication, HttpServletRequest request, HttpServletResponse response) {
        if (authentication == null) authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDto dto = (UserDto) service.loadUserByUsername(authentication.getName());
        return ResponseEntity.ok(dto.eraseCredentials());
    }
    
}



//http://localhost:8080/login/oauth2/code/google
// ?state=1H_Ro2BfkPEQdyLguGtz51G36021G_vzwQeEW_MQMzw%3D&code=4%2F0AfJohXktuCMi8_DxuHJKXyGRLaTQxAjucbtZoLc1VMj2sCxA6c2hWlT0hpbaBuaiffGRmQ&scope=email+profile+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.profile+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&authuser=0&prompt=consent