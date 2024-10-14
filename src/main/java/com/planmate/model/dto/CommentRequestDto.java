package com.planmate.model.dto;

import com.planmate.model.entity.Comment;
import com.planmate.model.entity.Plan;
import com.planmate.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * @author : leeyounggyo
 * @package : com.planmate.model.dto
 * @since : 2024. 10. 13.
 */
@Builder
@Getter
@AllArgsConstructor
public class CommentRequestDto {

    private Long planId;
    private Long userId;
    private String commentContent;

    public Comment toEntity(Plan plan, User user) {
        return Comment.builder()
                .plan(plan)
                .user(user)
                .commentContent(commentContent)
                .createDate(LocalDateTime.now())
                .build();
    }
}
