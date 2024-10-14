package com.planmate.service;

import com.planmate.model.dto.CommentRequestDto;
import com.planmate.model.dto.CommentResponseDto;
import com.planmate.model.entity.Comment;
import com.planmate.model.entity.Plan;
import com.planmate.model.entity.User;
import com.planmate.repository.CommentRepository;
import com.planmate.repository.PlanRepository;
import com.planmate.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : leeyounggyo
 * @package : com.planmate.service
 * @since : 2024. 10. 13.
 */
@Transactional
@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final PlanRepository planRepository;
    private final UserRepository userRepository;

    public Page<CommentResponseDto> searchCommentByPlan(Long planId, Pageable pageable) {
        Plan plan = planRepository.findById(planId)
                .orElseThrow(() -> new RuntimeException("Plan not found with id " + planId));

        return commentRepository.findAllByPlan(plan, pageable)
                .map(Comment::toDto);
    }

    public CommentResponseDto getComment(Long commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("comment not found"))
                .toDto();
    }

    public CommentResponseDto createComment(CommentRequestDto planRequestDto) {
        Plan plan = planRepository.findById(planRequestDto.getPlanId())
                .orElseThrow(() -> new RuntimeException("Plan not found with id " + planRequestDto.getPlanId()));
        User user = userRepository.findById(planRequestDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with id " + planRequestDto.getUserId()));

        return commentRepository.save(planRequestDto.toEntity(plan, user))
                .toDto();
    }

    public CommentResponseDto updateComment(Long commentId, CommentRequestDto commentRequestDto) {
        Comment findComment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("comment not found"));

        findComment.updateContent(commentRequestDto);
        Comment updateComment = commentRepository.save(findComment);
        return updateComment.toDto();
    }

    public void deleteComment(Long commentId) {
        Comment findComment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("comment not found"));

        commentRepository.delete(findComment);
    }
}
