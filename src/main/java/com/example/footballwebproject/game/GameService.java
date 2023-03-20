package com.example.footballwebproject.game;

import com.example.footballwebproject.comment.dto.CommentResponseDto;
import com.example.footballwebproject.comment.repository.CommentRepository;
import com.example.footballwebproject.entity.Comment;
import com.example.footballwebproject.entity.Game;
import com.example.footballwebproject.exception.ApiException;
import com.example.footballwebproject.exception.ExceptionEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GameService {
    private final GameRepository gameRepository;
    private final CommentRepository commentRepository;

    //게임 전체 조회
    @Transactional(readOnly = true)
    public GameListResponseDto getGames() {
        List<Game> gameList = gameRepository.findAll();
        return new GameListResponseDto(gameList.stream().map(GameResponseDto::new).toList());
    }

    //게임 단건 조회
    @Transactional(readOnly = true)
    public SingleGameResponseDto getGame(Long id) {
        Game game = gameRepository.findById(id).orElseThrow(
                () -> new ApiException(ExceptionEnum.GAME_NOT_FOUND)
        );
        GameResponseDto gameResponseDto = new GameResponseDto(game);
        List<Comment> commentList = commentRepository.findAllByGameIdOrderByCreatedAtDesc(id);
        List<CommentResponseDto> commentResponseDtoList = commentList.stream()
                .map(CommentResponseDto::new).toList();
        return new SingleGameResponseDto(gameResponseDto, commentResponseDtoList);
    }
}
