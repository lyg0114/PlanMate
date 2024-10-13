package com.planmate.controller;

import com.planmate.model.dto.PlanRequestDto;
import com.planmate.model.dto.PlanResponseDto;
import com.planmate.service.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : leeyounggyo
 * @package : com.planmate.controller
 * @since : 2024. 10. 13.
 */
@RequiredArgsConstructor
@RestController
public class PlanController {

    private final PlanService planService;

    // 일정 조회 (페이징)
    public Page<PlanResponseDto> searchPlan(PlanRequestDto planRequestDto) {
        return null;
    }

    // 일정 조회 (단건)
    public PlanResponseDto getPlan(long planId) {
        return null;
    }

    // 일정 생성
    public PlanResponseDto createPlan(PlanRequestDto planRequestDto) {
        return null;
    }

    // 일정 수정
    public PlanResponseDto updatePlan(long planId, PlanRequestDto planRequestDto) {
        return null;
    }

    // 일정 삭제
    public void deletePlan(long planId) {

    }
}
