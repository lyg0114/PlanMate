package com.planmate.model.dto;

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
public class PlanResponseDto {

    private Long planId;

    private String username;

    private String title;

    private String content;

}
