package com.example.footballwebproject.comment.dto;

import com.example.footballwebproject.entity.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class CommentResponseDto {


    private Long id;
    private String username;
    private String body;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private List<ReplyResponseDto> replyList;

    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.username = comment.getUser().getUsername();
        this.body = comment.getBody();
        this.createdAt = comment.getCreatedAt();
        this.modifiedAt = comment.getModifiedAt();
        this.replyList = new ArrayList<>();
    }

    public CommentResponseDto(Comment comment, List<ReplyResponseDto> replyList) {
        this.id = comment.getId();
        this.username = comment.getUser().getUsername();
        this.body = comment.getBody();
        this.createdAt = comment.getCreatedAt();
        this.modifiedAt = comment.getModifiedAt();
        this.replyList = replyList;
    }
}
