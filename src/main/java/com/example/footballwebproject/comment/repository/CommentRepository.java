package com.example.footballwebproject.comment.repository;

import com.example.footballwebproject.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByGameIdOrderByCreatedAtDesc(Long gameId);

    List<Comment> findAllByPathStartsWith(String path);

    List<Comment> findAllByPathStartsWithAndDepthGreaterThan(String path, Long depth);

    void deleteAllByPathStartsWith(String path);


    List<Comment> findAllByGameIdAndDepthOrderByCreatedAtDesc(Long id, Long parentCommentDepth);
}
