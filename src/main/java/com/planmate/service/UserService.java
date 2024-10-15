package com.planmate.service;

import com.planmate.model.dto.UserRequestDto;
import com.planmate.model.dto.UserResponseDto;
import com.planmate.model.entity.User;
import com.planmate.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : leeyounggyo
 * @package : com.planmate.service
 * @since : 2024. 10. 13.
 */
@Transactional
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Page<UserResponseDto> searchUser(Pageable pageable) {
        return userRepository.findAll(pageable)
                .map(User::toDto);
    }

    public UserResponseDto getUser(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("user not found with id " + userId))
                .toDto()
                ;
    }

    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        return userRepository.save(userRequestDto.toEntity())
                .toDto();
    }

    public UserResponseDto updateUser(Long userId, UserRequestDto userRequestDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("user not found with id " + userId));
        user.updateUser(userRequestDto);
        User save = userRepository.save(user);

        return save.toDto();
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

}
