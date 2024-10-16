package com.planmate.model.entity;

import com.planmate.model.define.Role;
import com.planmate.model.dto.UserRequestDto;
import com.planmate.model.dto.UserResponseDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : leeyounggyo
 * @package : com.planmate.model.entity
 * @since : 2024. 10. 13.
 */
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Builder.Default
    @OneToMany(mappedBy = "user")
    private List<Comment> comments = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "user")
    private List<Plan> plans = new ArrayList<>();

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    public UserResponseDto toDto() {
        return UserResponseDto.builder()
                .username(username)
                .email(email)
                .build();
    }

    public void updateUser(UserRequestDto userRequestDto) {
        if (userRequestDto.getUsername() != null) {
            username = userRequestDto.getUsername();
        }
    }
}
