package com.scoreboard.realtime_scoreboard.controller;

import com.scoreboard.realtime_scoreboard.dto.ScoreSubmissionDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/score")
public class ScoreController {

    @PostMapping
    public String submitScore(@RequestBody ScoreSubmissionDto scoreSubmissionDto) {
        // TODO: Validate score and update database/Redis leaderboard
        return "Score submitted successfully!";
    }
}
