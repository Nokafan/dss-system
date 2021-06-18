package dss.system.service.implementation;

import dss.system.dto.BuildingDto;
import dss.system.dto.SearchBuildingRequestDto;
import dss.system.service.BuildingPropertyService;
import dss.system.service.BuildingService;
import dss.system.service.SearchService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchServiceImpl implements SearchService {
    private final BuildingService buildingService;
    private final BuildingPropertyService buildingPropertyService;

    @Autowired
    public SearchServiceImpl(BuildingService buildingService,
                             BuildingPropertyService buildingPropertyService) {
        this.buildingService = buildingService;
        this.buildingPropertyService = buildingPropertyService;
    }

    @Override
    public List<BuildingDto> findBuildingsByListParams(SearchBuildingRequestDto requestDto) {
        List<Long> propertiesIdByVariations =
                buildingPropertyService.findBuildingPropertiesIdByVariations(
                requestDto.getQuestionId(),
                requestDto.getVariations());
        List<BuildingDto> buildingDtos = buildingService.findAllByBuildingProperties(
                requestDto.getBuildings(),
                propertiesIdByVariations);
        return buildingDtos;
    }
}
