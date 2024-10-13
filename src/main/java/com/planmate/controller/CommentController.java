package com.planmate.controller;

import com.planmate.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : leeyounggyo
 * @package : com.planmate.controller
 * @since : 2024. 10. 13.
 */
@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentService commentService;
}
