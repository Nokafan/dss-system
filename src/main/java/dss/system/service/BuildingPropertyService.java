package dss.system.service;

import dss.system.dto.BuildingPropertyDto;
import dss.system.dto.SearchBuildingPropertyDto;
import java.util.List;
import org.springframework.data.repository.query.Param;

public interface BuildingPropertyService {
    BuildingPropertyDto save(BuildingPropertyDto buildingPropertyDto);

    BuildingPropertyDto findById(Long id);

    List<BuildingPropertyDto> getVariationsByTitleId(long id);

    List<Long> findBuildingsPropertyByVariations(SearchBuildingPropertyDto searchBuildingPropertyDto);

    List<String> getUniqueBuildingPropertyVariations(Long id);
}
