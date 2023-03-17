package com.example.footballwebproject.game;

import com.example.footballwebproject.entity.Game;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<Game> getGames(){
        return gameRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Game getGame(Long id){
        return gameRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("그게임없어요")

        );
    }


}
