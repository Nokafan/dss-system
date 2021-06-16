package dss.system.service.implementation;

import dss.system.dto.UserDto;
import dss.system.dto.UserRegistrationDto;
import dss.system.dto.UserResponseDto;
import dss.system.entity.User;
import dss.system.exceptions.DataProcessingException;
import dss.system.repository.UserRepository;
import dss.system.service.UserService;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDto save(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        User savedUser = userRepository.save(user);
       return modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public UserResponseDto create(UserRegistrationDto requestDto) {
        User user = modelMapper.map(requestDto, User.class);
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserResponseDto.class);
    }

    @Override
    public UserDto findByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(user -> modelMapper.map(user, UserDto.class))
                .orElseThrow(() -> new DataProcessingException("Can`t find user by email: " + email));
    }
}
