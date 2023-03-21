package com.example.footballwebproject.comment.dto;

import com.example.footballwebproject.entity.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ReplyResponseDto {
    private Long id;
    private String username;
    private String body;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public ReplyResponseDto(Comment comment){
        this.id = comment.getId();
        this.username = comment.getUser().getUsername();
        this.body = comment.getBody();
        this.createdAt = comment.getCreatedAt();
        this.modifiedAt = comment.getModifiedAt();
    }
}
