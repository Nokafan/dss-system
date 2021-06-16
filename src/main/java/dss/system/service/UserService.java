package dss.system.service;

import dss.system.dto.UserDto;
import dss.system.dto.UserRegistrationDto;
import dss.system.dto.UserResponseDto;
import dss.system.entity.User;
import java.util.Optional;
import org.springframework.stereotype.Service;

public interface UserService {
    void deleteById(Long id);

    UserDto save(UserDto userDto);

    UserResponseDto create(UserRegistrationDto requestDto);

    UserDto findByEmail(String email);
}
