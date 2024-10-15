package com.planmate.controller;

import com.planmate.model.dto.UserInfo;
import com.planmate.model.dto.UserRequestDto;
import com.planmate.model.dto.UserResponseDto;
import com.planmate.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : leeyounggyo
 * @package : com.planmate.controller
 * @since : 2024. 10. 13.
 */
@RequiredArgsConstructor
@RestController
public class LoginController {

    private final UserService userService;

    // 회원가입
    @PostMapping("/auth/register")
    public UserResponseDto register(@RequestBody UserRequestDto userRequestDto) {
        return userService.register(userRequestDto);
    }

    @PostMapping("/auth/login")
    public UserInfo login(@RequestBody UserRequestDto userRequestDto) {
        return userService.getUserToken(userRequestDto.getEmail(), userRequestDto.getPassword());
    }

}
