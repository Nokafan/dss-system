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
public class SearchBuildingRequestDto {

    private Long questionId;

    private List<String> variations;

    private List<Long> buildings;
}
