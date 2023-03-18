package com.example.footballwebproject.entity;

import com.example.footballwebproject.comment.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Comment extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String body;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    User user;

    @ManyToOne
    @JoinColumn(name = "GAME_ID", nullable = false)
    Game game;


    public Comment(CommentRequestDto commentRequestDto, Game game, User user) {
        this.body = commentRequestDto.getBody();
        this.game = game;
        this.user = user;
    }


    // update 구현
    public void update(CommentRequestDto commentRequestDto) {
        this.body = commentRequestDto.getBody();
    }
}