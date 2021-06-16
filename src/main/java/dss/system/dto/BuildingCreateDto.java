package dss.system.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BuildingCreateDto {
    private String title;
    private String address;
    private List<BuildingPropertyCreateDto> buildingProperties;
}
