package com.planmate.repository;

import com.planmate.model.entity.Comment;
import com.planmate.model.entity.Plan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : leeyounggyo
 * @package : com.planmate.repository
 * @since : 2024. 10. 13.
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {

    Page<Comment> findAllByPlan(Plan plan, Pageable pageable);

}
