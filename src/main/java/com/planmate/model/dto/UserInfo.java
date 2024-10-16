package com.planmate.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * @author : leeyounggyo
 * @package : com.planmate.model.dto
 * @since : 2024. 10. 14.
 */
@Getter
@Builder
@AllArgsConstructor
public class UserInfo {

    private String email;
    private String token;

}
