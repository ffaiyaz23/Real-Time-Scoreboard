package com.scoreboard.realtime_scoreboard.controller;

import com.scoreboard.realtime_scoreboard.dto.UserLoginDto;
import com.scoreboard.realtime_scoreboard.dto.UserRegistrationDto;
import com.scoreboard.realtime_scoreboard.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public String register(@RequestBody UserRegistrationDto registrationDto) {
        return authenticationService.register(registrationDto);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserLoginDto loginDto) {
        return authenticationService.login(loginDto);
    }
}
