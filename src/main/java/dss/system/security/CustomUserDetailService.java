package dss.system.security;

import dss.system.dto.UserDto;
import dss.system.service.UserService;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    private final UserService userService;

    @Autowired
    public CustomUserDetailService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) {
        UserDto userDto = userService.findByEmail(userEmail);

        UserBuilder builder =
                org.springframework.security.core.userdetails.User.withUsername(userEmail);
        builder.password(userDto.getPassword());
        builder.authorities(Collections.emptyList());

        return builder.build();
    }
}
