package dss.system.service;

import dss.system.dto.BuildingDto;
import dss.system.entity.Building;
import java.util.List;

public interface BuildingService {

    BuildingDto save(BuildingDto buildingDto);

    void delete(BuildingDto buildingDto);

    List<BuildingDto> getAll();

    List<BuildingDto> getByPropertiesList(List<Long> propertiesIds);
}
