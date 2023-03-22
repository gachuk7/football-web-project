package com.example.footballwebproject.game;

import lombok.Getter;

import java.util.List;

@Getter
public class GameListResponseDto {
    private List<GameResponseDto> gameList;

    public GameListResponseDto(List<GameResponseDto> gameList) {
        this.gameList = gameList;
    }
}
