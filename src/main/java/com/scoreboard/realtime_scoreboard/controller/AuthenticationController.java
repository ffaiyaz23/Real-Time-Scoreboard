package com.scoreboard.realtime_scoreboard.controller;

import com.scoreboard.realtime_scoreboard.dto.UserLoginDto;
import com.scoreboard.realtime_scoreboard.dto.UserRegistrationDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @PostMapping("/register")
    public String register(@RequestBody UserRegistrationDto registrationDto) {
        // TODO: Implement registration logic
        return "User registered successfully!";
    }

    @PostMapping("/login")
    public String login(@RequestBody UserLoginDto loginDto) {
        // TODO: Implement login logic
        return "User logged in successfully!";
    }
}
