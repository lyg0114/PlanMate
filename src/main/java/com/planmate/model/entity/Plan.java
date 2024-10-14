package com.planmate.model.entity;

import com.planmate.model.dto.PlanRequestDto;
import com.planmate.model.dto.PlanResponseDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.LAZY;

/**
 * @author : leeyounggyo
 * @package : com.planmate.model.entity
 * @since : 2024. 10. 13.
 */
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Plan {

    @Id
    @Column(name = "plan_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long planId;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "plan")
    private List<Comment> comments = new ArrayList<>();

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    public PlanResponseDto toDto() {
        return PlanResponseDto.builder()
                .planId(planId)
                .title(title)
                .content(content)
                .build();
    }

    public void updatePlan(PlanRequestDto planRequestDto) {
        updateDate = LocalDateTime.now();

        if (planRequestDto.getTitle() != null) {
            title = planRequestDto.getTitle();
        }

        if (planRequestDto.getContent() != null) {
            content = planRequestDto.getContent();
        }
    }
}
