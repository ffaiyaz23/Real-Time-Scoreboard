package com.scoreboard.realtime_scoreboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @GetMapping("/topPlayers")
    public String getTopPlayersReport(@RequestParam(required = false) String period) {
        // TODO: Generate a report for top players based on the given period
        return "Top players report for period: " + (period != null ? period : "default");
    }
}
