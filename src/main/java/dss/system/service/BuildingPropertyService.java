package dss.system.service;

import dss.system.dto.BuildingPropertyDto;
import java.util.List;

public interface BuildingPropertyService {
    BuildingPropertyDto save(BuildingPropertyDto buildingPropertyDto);

    BuildingPropertyDto findById(Long id);

    List<BuildingPropertyDto> getVariationsByTitleId(long id);
}
