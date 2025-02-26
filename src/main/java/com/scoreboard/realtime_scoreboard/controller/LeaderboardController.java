package com.scoreboard.realtime_scoreboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/leaderboard")
public class LeaderboardController {

    @GetMapping("/global")
    public String getGlobalLeaderboard() {
        // TODO: Retrieve the global leaderboard from Redis
        return "Global Leaderboard";
    }

    @GetMapping("/{gameId}")
    public String getGameLeaderboard(@PathVariable String gameId) {
        // TODO: Retrieve the leaderboard for the specified game from Redis
        return "Leaderboard for game: " + gameId;
    }

    @GetMapping("/ranking")
    public String getUserRanking() {
        // TODO: Retrieve the ranking of the authenticated user from Redis
        return "User ranking";
    }
}
