package com.planmate.model.entity;

import com.planmate.model.dto.CommentRequestDto;
import com.planmate.model.dto.CommentResponseDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

import static jakarta.persistence.FetchType.LAZY;

/**
 * @author : leeyounggyo
 * @package : com.planmate.model.entity
 * @since : 2024. 10. 13.
 */
@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Comment {

    @Id
    @Column(name = "comment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "plan_id")
    private Plan plan;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "comment_content")
    private String commentContent;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    public CommentResponseDto toDto() {
        return null;
    }

    public void updateContent(CommentRequestDto commentRequestDto) {

    }
}
