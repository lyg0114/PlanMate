package com.planmate.model.dto;

import com.planmate.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * @author : leeyounggyo
 * @package : com.planmate.model.dto
 * @since : 2024. 10. 13.
 */
@Builder
@Getter
@AllArgsConstructor
public class UserRequestDto {

    private String email;
    private String username;
    private String password;

    public User toEntity() {
        return User.builder()
                .username(username)
                .email(email)
                .password(password)
                .createDate(LocalDateTime.now())
                .build();
    }
}
