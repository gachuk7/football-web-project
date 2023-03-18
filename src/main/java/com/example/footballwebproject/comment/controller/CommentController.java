package com.example.footballwebproject.comment.controller;

import com.example.footballwebproject.comment.dto.CommentRequestDto;
import com.example.footballwebproject.security.UserDetailsImpl;
import com.example.footballwebproject.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    //댓글 작성
    @PostMapping("/api/games/{gameId}/comments")
    public ResponseEntity<String> addComment(
            @PathVariable Long gameId,
            @RequestBody CommentRequestDto commentRequestDto,
            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return ResponseEntity.ok().body(commentService.addComment(gameId, commentRequestDto,
                userDetails.getUser()));
    }

    @PatchMapping("/api/games/{gameId}/comments/{commentId}")
    public ResponseEntity<String> updateComment(
            @PathVariable Long gameId,
            @PathVariable Long commentId,
            @RequestBody CommentRequestDto commentRequestDto,
            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return ResponseEntity.ok().body(commentService.updateComment(gameId,commentId,
                userDetails.getUser()));
    }

    @DeleteMapping("/api/games/{gameId}/comments/{commentId}")
    public ResponseEntity<String> deleteComment(
            @PathVariable Long gameId,
            @PathVariable Long commentId,
            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return ResponseEntity.ok().body(commentService.deleteComment(gameId,commentId,
                userDetails.getUser()));
    }

}