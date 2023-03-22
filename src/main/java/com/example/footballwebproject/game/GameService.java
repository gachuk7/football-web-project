package com.example.footballwebproject.game;

import com.example.footballwebproject.comment.dto.CommentResponseDto;
import com.example.footballwebproject.comment.dto.ReplyResponseDto;
import com.example.footballwebproject.comment.repository.CommentRepository;
import com.example.footballwebproject.entity.Comment;
import com.example.footballwebproject.entity.Game;
import com.example.footballwebproject.exception.ApiException;
import com.example.footballwebproject.exception.ExceptionEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {
    private static final Long PARENT_COMMENT_DEPTH = 1L;
    private final GameRepository gameRepository;
    private final CommentRepository commentRepository;

    //게임 전체 조회
    @Transactional(readOnly = true)
    public GameListResponseDto getGames() {
        List<Game> gameList = gameRepository.findAll();
        return new GameListResponseDto(gameList.stream().map(GameResponseDto::new).toList());
    }

    /**
     * 게임 단건 조회
     * 1. commnetList : 최상위 부모 댓글만 나옴
     * 2. replyList : 최상위 부모 댓글을 제외한 대댓글이 나옴
     */
    @Transactional(readOnly = true)
    public SingleGameResponseDto getGame(Long id) {
        Game game = gameRepository.findById(id).orElseThrow(
                () -> new ApiException(ExceptionEnum.GAME_NOT_FOUND)
        );

        GameResponseDto gameResponseDto = new GameResponseDto(game);

        List<Comment> commentList = commentRepository.findAllByGameIdAndDepthOrderByCreatedAtDesc(id, PARENT_COMMENT_DEPTH);
        List<CommentResponseDto> commentResponseDtoList =
                commentList.stream()
                .map(x -> {
                    List<Comment> replyList = commentRepository.findAllByPathStartsWithAndDepthGreaterThan(x.getPath(), PARENT_COMMENT_DEPTH);
                    return new CommentResponseDto(x, replyList.stream().map(ReplyResponseDto::new).toList());
                }).toList();

        return new SingleGameResponseDto(gameResponseDto, commentResponseDtoList);
    }

    @Transactional
    public GameResponseDto createGame(GameRequestDto requestDto){
        Game game = gameRepository.save(new Game(requestDto));
        return new GameResponseDto(game);
    }
}
