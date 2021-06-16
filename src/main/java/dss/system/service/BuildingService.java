package dss.system.service;

import dss.system.dto.BuildingDto;
import java.util.List;

public interface BuildingService {

    BuildingDto save(BuildingDto buildingDto);

    boolean delete(BuildingDto buildingDto);

    List<BuildingDto> getAll();

    List<BuildingDto> getByPropertiesList(List<Long> propertiesIds);
}
