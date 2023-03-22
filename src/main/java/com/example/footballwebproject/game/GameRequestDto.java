package com.example.footballwebproject.game;

import lombok.Getter;

@Getter
public class GameRequestDto {
    private Long gameId;
    private String teamA;
    private String teamB;
    private int scoreA;
    private int scoreB;
    private String imageA;
    private String imageB;

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public void setTeamA(String teamA) {
        this.teamA = teamA;
    }

    public void setTeamB(String teamB) {
        this.teamB = teamB;
    }

    public void setScoreA(int scoreA) {
        this.scoreA = scoreA;
    }

    public void setScoreB(int scoreB) {
        this.scoreB = scoreB;
    }

    public void setImageA(String imageA) {
        this.imageA = imageA;
    }

    public void setImageB(String imageB) {
        this.imageB = imageB;
    }
}
