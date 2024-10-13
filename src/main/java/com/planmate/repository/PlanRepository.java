package com.planmate.repository;

import com.planmate.model.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : leeyounggyo
 * @package : com.planmate.repository
 * @since : 2024. 10. 13.
 */
public interface PlanRepository extends JpaRepository<Plan, Long> {
}
