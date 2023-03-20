package com.example.footballwebproject.game;

import com.example.footballwebproject.entity.Game;
import lombok.Getter;

import java.util.List;

@Getter
public class GameResponseDto {
    private Long gameId;
    private String teamA;
    private String teamB;
    private int scoreA;
    private int scoreB;

    public GameResponseDto(Game game){
        this.gameId = game.getId();
        this.teamA = game.getTeamA();
        this.teamB = game.getTeamB();
        this.scoreA = game.getScoreA();
        this.scoreB = game.getScoreB();
    }


}
