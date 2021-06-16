package dss.system.dto;

import dss.system.validator.ValidEmail;
import dss.system.validator.ValidPassword;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationDto {
    @ValidEmail
    private String email;
    @ValidPassword
    private String password;
}
