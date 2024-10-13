package com.planmate.service;

import com.planmate.model.dto.PlanRequestDto;
import com.planmate.model.dto.PlanResponseDto;
import com.planmate.model.entity.Plan;
import com.planmate.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * @author : leeyounggyo
 * @package : com.planmate.service
 * @since : 2024. 10. 13.
 */
@Service
@RequiredArgsConstructor
public class PlanService {

    private final PlanRepository planRepository;

    public Page<PlanResponseDto> searchPlan(PlanRequestDto planRequestDto) {
        return null;
    }

    public PlanResponseDto getPlan(Long planId) {
        Plan findPlan = planRepository.findById(planId).get();
        PlanResponseDto findPlanDto = findPlan.toDto();
        return findPlanDto;
    }

    public PlanResponseDto createPlan(PlanRequestDto planRequestDto) {
        return null;
    }

    public PlanResponseDto updatePlan(Long planId, PlanRequestDto planRequestDto) {
        return null;
    }

    public void deletePlan(Long planId) {

    }
}
