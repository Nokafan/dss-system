package dss.system.service;

import dss.system.dto.BuildingCreateDto;
import dss.system.dto.BuildingDto;
import dss.system.dto.SearchRequestDto;
import java.util.List;

public interface BuildingService {

    BuildingDto save(BuildingDto buildingDto);

    BuildingDto save(BuildingCreateDto buildingDto);

    boolean delete(BuildingDto buildingDto);

    List<BuildingDto> getAll();

    List<BuildingDto> getAllByIds(List<Long> ids);

    List<Long> findAllByBuildingPropertiesIsIn(SearchRequestDto searchRequestDto);
}
