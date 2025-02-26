package com.scoreboard.realtime_scoreboard.repository;

import com.scoreboard.realtime_scoreboard.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {
    // TODO: Add custom queries if needed
}
