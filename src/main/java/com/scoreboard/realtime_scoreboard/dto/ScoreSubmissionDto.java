package com.scoreboard.realtime_scoreboard.dto;

import lombok.Data;

@Data
public class ScoreSubmissionDto {
    private Long userId;       // Alternatively, you can use username if preferred
    private String gameId;
    private Double scoreValue;
}
