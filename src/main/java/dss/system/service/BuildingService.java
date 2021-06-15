package dss.system.service;

import dss.system.dto.BuildingDto;
import dss.system.entity.Building;

public interface BuildingService {
    Building save (Building building);
    Building save (BuildingDto buildingDto);
    void delete (Building building);
    void delete (BuildingDto buildingDto);

}
