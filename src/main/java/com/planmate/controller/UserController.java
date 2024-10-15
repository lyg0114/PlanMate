package com.planmate.controller;

import com.planmate.model.dto.UserRequestDto;
import com.planmate.model.dto.UserResponseDto;
import com.planmate.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

/**
 * @author : leeyounggyo
 * @package : com.planmate.controller
 * @since : 2024. 10. 13.
 */
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping("/api/user/search")
    public Page<UserResponseDto> searchUser(Pageable pageable) {
        return userService.searchUser(pageable);
    }

    // 사용자 조회 (단건)
    @GetMapping("/api/user/{user-id}")
    public UserResponseDto getUser(@PathVariable("user-id") Long userId) {
        return userService.getUser(userId);
    }

    // 사용자 생성
    @PostMapping("/api/user")
    public UserResponseDto createUser(@RequestBody UserRequestDto userRequestDto) {
        return userService.createUser(userRequestDto);
    }

    // 사용자 수정
    @PatchMapping("/api/user/{user-id}")
    public UserResponseDto updateUser(@PathVariable("user-id") Long userId, @RequestBody UserRequestDto userRequestDto) {
        return userService.updateUser(userId, userRequestDto);
    }

    // 사용자 삭제
    @DeleteMapping("/api/user/{user-id}")
    public void deleteUser(@PathVariable("user-id") Long userId) {
        userService.deleteUser(userId);
    }

}
