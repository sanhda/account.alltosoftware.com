package com.alltosoftware.account.controller;

import com.alltosoftware.account.dto.RegistrationDto;
import com.alltosoftware.account.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    private UserService userService;
    private AuthenticationManager authenticationManager;

    @Autowired
    public AuthController(UserService userService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("user") RegistrationDto user) {
        Authentication authenticationRequest =
                UsernamePasswordAuthenticationToken.unauthenticated(user.getUsername(), user.getPassword());
        Authentication authenticationResponse =
                this.authenticationManager.authenticate(authenticationRequest);
        SecurityContextHolder.getContext().setAuthentication(authenticationResponse);
        return "redirect:/";
    }
}
