package com.scoreboard.realtime_scoreboard.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// This class can be used as a POJO for leaderboard responses.
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeaderboardEntry {
    private String username;
    private Double score;
    private Long rank;
}
