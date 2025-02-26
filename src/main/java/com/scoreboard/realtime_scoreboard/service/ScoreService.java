package com.scoreboard.realtime_scoreboard.service;

import com.scoreboard.realtime_scoreboard.dto.ScoreSubmissionDto;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {

    // TODO: Inject ScoreRepository, UserRepository, and RedisTemplate

    public String submitScore(ScoreSubmissionDto scoreSubmissionDto) {
        // TODO: Validate and persist score, update Redis leaderboard
        return "Score processed successfully";
    }
}
