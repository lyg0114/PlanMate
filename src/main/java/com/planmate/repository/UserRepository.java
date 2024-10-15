package com.planmate.repository;

import com.planmate.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author : leeyounggyo
 * @package : com.planmate.repository
 * @since : 2024. 10. 13.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
