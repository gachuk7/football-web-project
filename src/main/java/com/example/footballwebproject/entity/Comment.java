package com.example.footballwebproject.entity;

import javax.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String title;

    @Column(nullable = false)
    String body;

    @ManyToOne
    @JoinColumn(name="USER_ID", nullable = false)
    User user;

    @ManyToOne
    @JoinColumn(name="GAME_ID", nullable = false)
    Game game;
}
