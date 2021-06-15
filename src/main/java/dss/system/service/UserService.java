package dss.system.service;

import dss.system.dto.UserDto;
import dss.system.entity.User;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void deleteById(Long id);

    UserDto save(UserDto userDto);

    UserDto findByEmail(String email);
}
