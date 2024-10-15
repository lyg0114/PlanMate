package com.planmate.service;

import com.planmate.model.dto.PlanRequestDto;
import com.planmate.model.dto.PlanResponseDto;
import com.planmate.model.entity.Plan;
import com.planmate.repository.PlanRepository;
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
public class PlanService {

    private final PlanRepository planRepository;

    public Page<PlanResponseDto> searchPlan(PlanRequestDto planRequestDto) {
        return null;
    }

    public Page<PlanResponseDto> getPage(Pageable pageable) {
        Page<Plan> all = planRepository.findAll(pageable);
        Page<PlanResponseDto> map = all.map(Plan::toDto);
        return map;
    }

    public PlanResponseDto getPlan(Long planId) {
        Plan findPlan = planRepository.findById(planId).get();
        PlanResponseDto findPlanDto = findPlan.toDto();
        return findPlanDto;
    }

    // planRequestDto -> plan
    public PlanResponseDto createPlan(PlanRequestDto planRequestDto) {
        Plan plan = planRequestDto.toEntity();
        Plan savePlan = planRepository.save(plan);
        PlanResponseDto saveddto = savePlan.toDto();
        return saveddto;
    }

    public PlanResponseDto updatePlan(Long planId, PlanRequestDto planRequestDto) {
        Plan findPlan = planRepository.findById(planId).get();
        findPlan.updatePlan(planRequestDto);
        Plan updatedPlan = planRepository.save(findPlan);
        return updatedPlan.toDto();
    }

    public void deletePlan(Long planId) {
        planRepository.deleteById(planId);
    }
}
