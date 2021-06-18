package dss.system.service;

import dss.system.dto.BuildingDto;
import dss.system.dto.SearchBuildingRequestDto;
import java.util.List;

public interface SearchService {
    List<BuildingDto> findBuildingsByListParams(SearchBuildingRequestDto searchBuildingRequestDto);
}
