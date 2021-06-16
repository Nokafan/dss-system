package dss.system.service;

import dss.system.dto.UserDto;
import dss.system.dto.UserRegistrationDto;
import dss.system.dto.UserResponseDto;

public interface UserService {
    void deleteById(Long id);

    UserDto save(UserDto userDto);

    UserResponseDto create(UserRegistrationDto requestDto);

    UserDto findByEmail(String email);
}
