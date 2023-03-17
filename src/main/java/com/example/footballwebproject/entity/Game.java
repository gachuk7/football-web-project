package com.example.footballwebproject.entity;

import javax.persistence.*;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String teamA;

    @Column(nullable = false)
    String teamB;

    @Column(nullable = false)
    Integer scoreA;

    @Column(nullable = false)
    Integer scoreB;
}
