package com.example.footballwebproject.game;

import com.example.footballwebproject.comment.dto.CommentResponseDto;
import lombok.Getter;

import java.util.List;

@Getter
public class SingleGameResponseDto {
    private GameResponseDto gameInfo;
    private List<CommentResponseDto> commentList;

    public SingleGameResponseDto(GameResponseDto gameInfo,
                                 List<CommentResponseDto> commentResponseDtoList) {
        this.gameInfo = gameInfo;
        this.commentList = commentResponseDtoList;
    }
}
