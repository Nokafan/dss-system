package dss.system.dto;

import dss.system.validator.ValidName;
import dss.system.validator.ValidPassword;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDto {
    @ValidName
    private String username;
    @ValidPassword
    private String password;
}
