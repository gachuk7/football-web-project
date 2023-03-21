package com.example.footballwebproject.entity;

import com.example.footballwebproject.comment.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 경로 열거 방식
 * 1 : 1/
 * 1.1 : 1/2/
 * 1.1.1 : 1/2/6/
 * 2 : 3/
 * 2.2 : 3/4/
 * 3 : 5/
 */
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

    @Column(nullable = false)
    String path;

    @Column(nullable = false)
    Long depth;     // 1 이면 댓글, 2 이상이면 대댓글

    public Comment(CommentRequestDto commentRequestDto, Game game, User user) {
        this.body = commentRequestDto.getBody();
        this.game = game;
        this.user = user;
        this.path = "";
        this.depth = 1L;
    }

    public Comment(CommentRequestDto commentRequestDto, Game game, User user, Long depth) {
        this.body = commentRequestDto.getBody();
        this.game = game;
        this.user = user;
        this.path = "";
        this.depth = depth;
    }

    // update 구현
    public void update(CommentRequestDto commentRequestDto) {
        this.body = commentRequestDto.getBody();
    }

    // insert 이후에 호출되는 path 정보 초기화 메서드
    public void updatePath(String path) {
        this.path = path;
    }
}