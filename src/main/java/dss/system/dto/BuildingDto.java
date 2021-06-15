package dss.system.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BuildingDto {
    private Long id;
    private String title;
    private String address;
    private List<BuildingPropertyDto> buildingProperties;
}
