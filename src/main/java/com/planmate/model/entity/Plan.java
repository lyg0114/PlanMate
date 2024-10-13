package com.planmate.model.entity;

import com.planmate.model.dto.PlanResponseDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

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
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long planId;

    @Column
    private String username;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private LocalDateTime createDate;

    @Column
    private LocalDateTime updateDate;

    public PlanResponseDto toDto() {
        PlanResponseDto planResponseDto = PlanResponseDto.builder()
                .planId(planId)
                .username(username)
                .title(title)
                .content(content)
                .build();

        return planResponseDto;
    }
}
