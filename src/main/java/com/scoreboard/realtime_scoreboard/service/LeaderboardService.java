package com.scoreboard.realtime_scoreboard.service;

import com.scoreboard.realtime_scoreboard.model.LeaderboardEntry;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LeaderboardService {

    // TODO: Inject RedisTemplate and add methods to interact with Redis sorted sets

    public List<LeaderboardEntry> getGlobalLeaderboard() {
        // TODO: Retrieve global leaderboard from Redis
        return List.of(); // return empty list for now
    }

    public List<LeaderboardEntry> getGameLeaderboard(String gameId) {
        // TODO: Retrieve game-specific leaderboard from Redis
        return List.of();
    }

    public LeaderboardEntry getUserRanking(String username) {
        // TODO: Retrieve a specific user's ranking from Redis
        return new LeaderboardEntry(username, 0.0, 0L);
    }
}
