package com.planmate.controller;

import com.planmate.model.dto.CommentRequestDto;
import com.planmate.model.dto.CommentResponseDto;
import com.planmate.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

/**
 * @author : leeyounggyo
 * @package : com.planmate.controller
 * @since : 2024. 10. 13.
 */
@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/api/comment/plan/{plan-id}")
    public Page<CommentResponseDto> searchCommentByPlan(@PathVariable("plan-id") Long planId, Pageable pageable) {
        return commentService.searchCommentByPlan(planId, pageable);
    }

    // 댓글 조회 (단건)
    @GetMapping("/api/comment/{comment-id}")
    public CommentResponseDto getComment(@PathVariable("comment-id") Long commentId) {
        return commentService.getComment(commentId);
    }

    // 댓글 생성
    @PostMapping("/api/comment")
    public CommentResponseDto createComment(@RequestBody CommentRequestDto commentRequestDto) {
        return commentService.createComment(commentRequestDto);
    }

    @PatchMapping("/api/comment/{comment-id}")
    public CommentResponseDto updateComment(@PathVariable("comment-id") Long commentId, @RequestBody CommentRequestDto commentRequestDto) {
        return commentService.updateComment(commentId, commentRequestDto);
    }

    // 일정 삭제
    @DeleteMapping("/api/comment/{comment-id}")
    public void deleteComment(@PathVariable("comment-id") Long commentId) {
        commentService.deleteComment(commentId);
    }
}
