package com.example.footballwebproject.game;

import com.example.footballwebproject.entity.Game;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity getGames() {
        return ResponseEntity.ok().body(gameService.getGames());
    }

    //게임조회 - 상세
    @GetMapping("/{gameId}")
    public ResponseEntity getGame(@PathVariable Long gameId) {
        return ResponseEntity.ok().body(gameService.getGame(gameId));
    }

    //게임 만들기
    @PostMapping
    public ResponseEntity createGame(@RequestBody GameRequestDto requestDto){
        return ResponseEntity.ok().body(gameService.createGame(requestDto));
    }
}
