package com.planmate.model.dto;

import com.planmate.model.entity.Plan;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * @author : leeyounggyo
 * @package : com.planmate.model.dto
 * @since : 2024. 10. 13.
 */
@Builder
@Getter
@AllArgsConstructor
public class PlanRequestDto {

    private String username;

    private String title;

    private String content;

    public Plan toEntity() {
        return Plan.builder()
                .title(title)
                .content(content)
                .build();
    }
}
