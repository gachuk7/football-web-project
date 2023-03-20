package com.example.footballwebproject.game;

import com.example.footballwebproject.entity.Game;
import com.example.footballwebproject.exception.ApiException;
import com.example.footballwebproject.exception.ExceptionEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {
    private final GameRepository gameRepository;

    //게임 전체 조회
    @Transactional(readOnly = true)
    public List<GameResponseDto> getGames() {
        List<GameResponseDto> gameResponseDtoList = new ArrayList<>();
        List<Game> gameList = gameRepository.findAll();
        for (Game game : gameList){
            gameResponseDtoList.add(new GameResponseDto(game));
        }
        return gameResponseDtoList;
    }

    //게임 단건 조회
    @Transactional(readOnly = true)
    public GameResponseDto getGame(Long id){
        Game game = gameRepository.findById(id).orElseThrow(
                () -> new ApiException(ExceptionEnum.GAME_NOT_FOUND)
        );

        return new GameResponseDto(game);
    }


}
