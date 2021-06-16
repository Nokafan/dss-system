package dss.system.dto;

import java.util.List;
import lombok.Data;

@Data
public class SearchRequestDto {
    List<Long> buildingId;
    List<Long> propertiesIds;
}
