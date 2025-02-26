package com.scoreboard.realtime_scoreboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable)  // Disable CSRF for development purposes
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/**").permitAll()       // Allow registration & login
                        .requestMatchers("/api/leaderboard/**").permitAll()  // Publicly visible scoreboard
                        .anyRequest().authenticated()                       // All other endpoints require auth
                )
                .httpBasic(Customizer.withDefaults());  // You can replace this with JWT filters later

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
