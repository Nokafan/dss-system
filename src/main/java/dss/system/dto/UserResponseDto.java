package dss.system.dto;

import java.time.LocalDate;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
    private Long id;
    private String name;
    private String familyName;
    private LocalDate dateOfBirth;
    private String email;
}
