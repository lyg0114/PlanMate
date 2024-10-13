package com.planmate.controller;

import com.planmate.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : leeyounggyo
 * @package : com.planmate.controller
 * @since : 2024. 10. 13.
 */
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;
}
