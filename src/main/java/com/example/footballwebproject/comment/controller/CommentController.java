package com.example.footballwebproject.comment.controller;

import com.example.footballwebproject.comment.dto.CommentRequestDto;
import com.example.footballwebproject.comment.dto.CommentResponseDto;
import com.example.footballwebproject.comment.dto.ReplyResponseDto;
import com.example.footballwebproject.security.UserDetailsImpl;
import com.example.footballwebproject.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    //댓글 작성
    @PostMapping("/api/games/{gameId}/comments")
    public ResponseEntity<CommentResponseDto> addComment(
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
        return ResponseEntity.ok()
                .body(commentService.updateComment(commentId, commentRequestDto, userDetails.getUser()));
    }

    @DeleteMapping("/api/games/{gameId}/comments/{commentId}")
    public ResponseEntity<String> deleteComment(
            @PathVariable Long gameId,
            @PathVariable Long commentId,
            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return ResponseEntity.ok()
                .body(commentService.deleteComment(commentId, userDetails.getUser()));
    }

    /**
     * 대댓글 작성
     */
    @PostMapping("/api/games/{gameId}/comments/{commentId}/reply")
    public ResponseEntity<ReplyResponseDto> addReply(
            @PathVariable Long gameId,
            @PathVariable Long commentId,
            @RequestBody CommentRequestDto commentRequestDto,
            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return ResponseEntity.ok().body(commentService.addReply(commentId, gameId, commentRequestDto, userDetails.getUser()));
    }

    /**
     * 대댓글 조회 : 특정 최상위 부모 댓글의 대댓글 조회하기
     */
    @GetMapping("/api/games/{gameId}/comments/{commentId}/reply")
    public ResponseEntity<List<ReplyResponseDto>> getReply(@PathVariable Long commentId) {
        return ResponseEntity.ok().body(commentService.getReply(commentId));
    }

    /**
     * 대댓글 수정
     */
    @PatchMapping("/api/games/{gameId}/comments/{commentId}/reply/{replyId}")
    public ResponseEntity<ReplyResponseDto> updateReply(
            @PathVariable Long commentId,
            @PathVariable Long replyId,
            @RequestBody CommentRequestDto commentRequestDto,
            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return ResponseEntity.ok().body(commentService.updateReply(commentId, replyId, commentRequestDto, userDetails.getUser()));
    }

    /**
     * 대댓글 삭제
     */
    @DeleteMapping("/api/games/{gameId}/comments/{commentId}/reply/{replyId}")
    public ResponseEntity<String> deleteReply(@PathVariable Long replyId,
                                              @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return ResponseEntity.ok().body(commentService.deleteReply(replyId, userDetails.getUser()));
    }
}