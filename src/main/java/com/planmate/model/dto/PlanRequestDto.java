package com.planmate.model.dto;

import com.planmate.model.entity.Plan;
import lombok.Getter;

/**
 * @author : leeyounggyo
 * @package : com.planmate.model.dto
 * @since : 2024. 10. 13.
 */
@Getter
public class PlanRequestDto {

    private String username;

    private String title;

    private String content;

    public Plan toEntity() {
        Plan plan = Plan.builder()
                .username(username)
                .title(title)
                .content(content)
                .build();

        return plan;
    }
}
