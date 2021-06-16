package dss.system.controller;

import dss.system.dto.UserDto;
import dss.system.dto.UserRegistrationDto;
import dss.system.dto.UserResponseDto;
import dss.system.entity.User;
import dss.system.service.UserService;
import javax.validation.Valid;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Log4j
@RestController
@RequestMapping("/api/user")
public class UserController {
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserService userService;

    @Autowired
    public UserController(BCryptPasswordEncoder passwordEncoder,
                          UserService userService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @PostMapping("/registration")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserResponseDto> createUser(@Valid @RequestBody UserRegistrationDto requestDto) {
        requestDto.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        UserResponseDto userDto = userService.create(requestDto);
        log.info("User created id: " + userDto.getId() + " email: " + userDto.getEmail());
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }
}
