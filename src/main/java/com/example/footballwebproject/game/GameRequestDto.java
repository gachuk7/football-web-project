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
}
