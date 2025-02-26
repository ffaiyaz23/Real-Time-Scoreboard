package com.scoreboard.realtime_scoreboard.service;

import com.scoreboard.realtime_scoreboard.dto.UserLoginDto;
import com.scoreboard.realtime_scoreboard.dto.UserRegistrationDto;
import com.scoreboard.realtime_scoreboard.model.User;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    // TODO: Inject UserRepository and PasswordEncoder, add business logic

    public String register(UserRegistrationDto registrationDto) {
        // TODO: Implement registration logic
        return "Registration successful";
    }

    public String login(UserLoginDto loginDto) {
        // TODO: Implement login logic (authentication, JWT token generation)
        return "Login successful";
    }
}
