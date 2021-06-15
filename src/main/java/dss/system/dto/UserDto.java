package dss.system.dto;

import dss.system.configuration.Constants;
import java.time.LocalDate;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String familyName;
    @DateTimeFormat(pattern = Constants.PATTERN_DATE)
    private LocalDate dateOfBirth;
    private String email;
    private String password;
}
