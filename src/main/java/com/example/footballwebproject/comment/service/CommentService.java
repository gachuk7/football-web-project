package com.example.footballwebproject.comment.service;

import com.example.footballwebproject.comment.dto.CommentRequestDto;
import com.example.footballwebproject.comment.dto.CommentResponseDto;
import com.example.footballwebproject.comment.repository.CommentRepository;
import com.example.footballwebproject.entity.Comment;
import com.example.footballwebproject.entity.Game;
import com.example.footballwebproject.entity.User;
import com.example.footballwebproject.exception.ApiException;
import com.example.footballwebproject.exception.ExceptionEnum;
import com.example.footballwebproject.game.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final GameRepository gameRepository;

    @Transactional
    public CommentResponseDto addComment(Long gameId, CommentRequestDto commentRequestDto, User user) {
        Game game = gameRepository.findById(gameId).orElseThrow(
                () -> new ApiException(ExceptionEnum.GAME_NOT_FOUND)
        );

        Comment comment = commentRepository.save(new Comment(commentRequestDto, game, user));
        CommentResponseDto responseDto = new CommentResponseDto(comment);
        return responseDto;
    }

    @Transactional
    public String updateComment(Long commentId, CommentRequestDto commentRequestDto, User user) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new ApiException(ExceptionEnum.COMMENT_NOT_FOUND)
        );

        if (!comment.getUser().getId().equals(user.getId())) {
            throw new ApiException(ExceptionEnum.INVALID_USER_UPDATE);
        }
        // 로그인 한 유저는 소문자유저 comment 유저는 데이터베이스 에 가져오는 칼럼을 가져오게 되면 서로 일치하면 수정 가능
        comment.update(commentRequestDto);
        CommentResponseDto responseDto = new CommentResponseDto(comment);

        return "댓글 수정 성공";
    }

    @Transactional
    public String deleteComment(Long commentId, User user) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new ApiException(ExceptionEnum.COMMENT_NOT_FOUND)
        );

        if (!comment.getUser().getId().equals(user.getId())) {
            throw new ApiException(ExceptionEnum.INVALID_USER_DELETE);
        }

        commentRepository.delete(comment);

        return "댓글 삭제 성공";
    }
}

