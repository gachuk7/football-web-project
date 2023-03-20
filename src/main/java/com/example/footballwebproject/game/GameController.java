package com.example.footballwebproject.game;

import com.example.footballwebproject.entity.Game;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/games")
@CrossOrigin
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    // 게임조회 - 전체
    @GetMapping
    public GameListResponseDto getGames() {
        return gameService.getGames();
    }

    //게임조회 - 상세
    @GetMapping("/{gameId}")
    public SingleGameResponseDto getGame(@PathVariable Long gameId) {
        return gameService.getGame(gameId);
    }
}
