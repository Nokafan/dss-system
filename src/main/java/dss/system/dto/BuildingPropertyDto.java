package dss.system.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BuildingPropertyDto {

    private Long id;

    private PropertyDto title;

    private String value;
}
