package dss.system.dto;

import static dss.system.configuration.Constants.PATTERN_DATE;

import dss.system.validator.ValidEmail;
import dss.system.validator.ValidName;
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
    @ValidName
    private String name;
    @ValidEmail
    private String email;
    @ValidPassword
    private String password;
}
