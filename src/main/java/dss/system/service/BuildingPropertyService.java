package dss.system.service;

import dss.system.dto.BuildingPropertyDto;
import java.util.List;

public interface BuildingPropertyService {
    BuildingPropertyDto save(BuildingPropertyDto buildingPropertyDto);

    List<BuildingPropertyDto> getVariationsByTitleId(long id);

    List<String> getUniqueBuildingPropertyVariations(Long id);

    List<Long> findBuildingPropertiesIdByVariations(Long propertyId, List<String> variations);
}
