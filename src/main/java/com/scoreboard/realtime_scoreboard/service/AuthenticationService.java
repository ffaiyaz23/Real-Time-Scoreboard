package com.scoreboard.realtime_scoreboard.service;

import com.scoreboard.realtime_scoreboard.dto.UserLoginDto;
import com.scoreboard.realtime_scoreboard.dto.UserRegistrationDto;
import com.scoreboard.realtime_scoreboard.model.User;
import com.scoreboard.realtime_scoreboard.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.Optional;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // JWT secret key and expiration time (in milliseconds)
    private final Key jwtSecretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private final long jwtExpirationMs = 3600000; // 1 hour

    @Autowired
    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String register(UserRegistrationDto registrationDto) {
        // Check if username already exists
        Optional<User> existingUser = userRepository.findByUsername(registrationDto.getUsername());
        if (existingUser.isPresent()) {
            return "Username already exists";
        }
        // Create new user with encoded password
        User user = new User();
        user.setUsername(registrationDto.getUsername());
        user.setEmail(registrationDto.getEmail());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        userRepository.save(user);
        return "User registered successfully";
    }

    public String login(UserLoginDto loginDto) {
        // Find user by username
        Optional<User> userOptional = userRepository.findByUsername(loginDto.getUsername());
        if (userOptional.isEmpty()) {
            return "Invalid username or password";
        }
        User user = userOptional.get();
        // Verify password
        if (!passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
            return "Invalid username or password";
        }
        // Generate and return JWT token
        return generateToken(user);
    }

    private String generateToken(User user) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationMs);
        return Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(jwtSecretKey)
                .compact();
    }
}
