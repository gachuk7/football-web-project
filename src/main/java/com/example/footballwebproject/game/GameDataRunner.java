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
        GameRequestDto requestDto1 = new GameRequestDto();
        requestDto1.setTeamA("Real Madrid");
        requestDto1.setTeamB("Team Korea");
        requestDto1.setScoreA(0);
        requestDto1.setScoreB(17);
        requestDto1.setImageA("https://secure.cache.images.core.optasports.com/soccer/teams/75x75/uuid_3kq9cckrnlogidldtdie2fkbl.png");
        requestDto1.setImageB("https://secure.cache.images.core.optasports.com/soccer/teams/75x75/uuid_1yghbv1c71b37eenutbwnvvq.png");

        GameRequestDto requestDto2 = new GameRequestDto();
        requestDto2.setTeamA("Arsenal");
        requestDto2.setTeamB("Team Korea");
        requestDto2.setScoreA(0);
        requestDto2.setScoreB(9);
        requestDto2.setImageA("https://secure.cache.images.core.optasports.com/soccer/teams/30x30/uuid_4dsgumo7d4zupm2ugsvm4zm4d.png");
        requestDto2.setImageB("https://secure.cache.images.core.optasports.com/soccer/teams/75x75/uuid_1yghbv1c71b37eenutbwnvvq.png");

        GameRequestDto requestDto3 = new GameRequestDto();
        requestDto3.setTeamA("Manchester City");
        requestDto3.setTeamB("Team Korea");
        requestDto3.setScoreA(0);
        requestDto3.setScoreB(87);
        requestDto3.setImageA("https://secure.cache.images.core.optasports.com/soccer/teams/30x30/uuid_a3nyxabgsqlnqfkeg41m6tnpp.png");
        requestDto3.setImageB("https://secure.cache.images.core.optasports.com/soccer/teams/75x75/uuid_1yghbv1c71b37eenutbwnvvq.png");

        GameRequestDto requestDto4 = new GameRequestDto();
        requestDto4.setTeamA("Manchester United");
        requestDto4.setTeamB("Team Korea");
        requestDto4.setScoreA(0);
        requestDto4.setScoreB(5);
        requestDto4.setImageA("https://secure.cache.images.core.optasports.com/soccer/teams/30x30/uuid_6eqit8ye8aomdsrrq0hk3v7gh.png");
        requestDto4.setImageB("https://secure.cache.images.core.optasports.com/soccer/teams/75x75/uuid_1yghbv1c71b37eenutbwnvvq.png");

        GameRequestDto requestDto5 = new GameRequestDto();
        requestDto5.setTeamA("Tottenham Hotspur");
        requestDto5.setTeamB("Team Korea");
        requestDto5.setScoreA(0);
        requestDto5.setScoreB(7);
        requestDto5.setImageA("https://secure.cache.images.core.optasports.com/soccer/teams/30x30/uuid_22doj4sgsocqpxw45h607udje.png");
        requestDto5.setImageB("https://secure.cache.images.core.optasports.com/soccer/teams/75x75/uuid_1yghbv1c71b37eenutbwnvvq.png");

        GameRequestDto requestDto6 = new GameRequestDto();
        requestDto6.setTeamA("Newcastle United");
        requestDto6.setTeamB("Team Korea");
        requestDto6.setScoreA(0);
        requestDto6.setScoreB(3);
        requestDto6.setImageA("https://secure.cache.images.core.optasports.com/soccer/teams/30x30/uuid_7vn2i2kd35zuetw6b38gw9jsz.png");
        requestDto6.setImageB("https://secure.cache.images.core.optasports.com/soccer/teams/75x75/uuid_1yghbv1c71b37eenutbwnvvq.png");


//        gameService.createGame(requestDto1);
//        gameService.createGame(requestDto2);
//        gameService.createGame(requestDto3);
//        gameService.createGame(requestDto4);
//        gameService.createGame(requestDto5);
//        gameService.createGame(requestDto6);
    }

}
