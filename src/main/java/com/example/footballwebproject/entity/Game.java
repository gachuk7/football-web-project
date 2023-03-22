package com.example.footballwebproject.entity;

import com.example.footballwebproject.game.GameRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
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

    @Column
    String imageA;

    @Column
    String imageB;

    public Game(GameRequestDto requestDto){
        this.teamA = requestDto.getTeamA();
        this.teamB = requestDto.getTeamB();
        this.scoreA = requestDto.getScoreA();
        this.scoreB = requestDto.getScoreB();
        this.imageA = requestDto.getImageA();
        this.imageB = requestDto.getImageB();

    }
}
