package com.example.footballwebproject.game;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GameDataRunner implements ApplicationRunner {
    private final GameService gameService;

    @Override
    public void run(ApplicationArguments args) {
        GameRequestDto requestDto = new GameRequestDto();
        requestDto.setTeamA("Real Madrid");
        requestDto.setTeamB("Team Korea");
        requestDto.setScoreA(0);
        requestDto.setScoreB(17);
        requestDto.setImageA("https://secure.cache.images.core.optasports.com/soccer/teams/75x75/uuid_3kq9cckrnlogidldtdie2fkbl.png");
        requestDto.setImageB("https://secure.cache.images.core.optasports.com/soccer/teams/75x75/uuid_1yghbv1c71b37eenutbwnvvq.png");

        gameService.createGame(requestDto);
    }

}
