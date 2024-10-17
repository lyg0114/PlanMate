package com.planmate.model.dto;

import com.planmate.config.PwEncoder;
import com.planmate.model.define.Role;
import com.planmate.model.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
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

    @Email
    private String email;

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    @NotEmpty
    private String role;

    public User toEntity(PwEncoder pwEncoder) {
        return User.builder()
                .username(username)
                .email(email)
                .password(pwEncoder.encryptPassword(password))
                .createDate(LocalDateTime.now())
                .role(getRole())
                .build();
    }

    private Role getRole() {
        if (role.equalsIgnoreCase("admin")) {
            return Role.ADMIN;
        } else {
            return Role.USER;
        }
    }

}
