package dss.system.service;

import dss.system.dto.BuildingCreateDto;
import dss.system.dto.BuildingDto;
import dss.system.dto.SearchRequestDto;
import dss.system.entity.Building;
import java.util.List;
import org.springframework.data.repository.query.Param;

public interface BuildingService {

    BuildingDto save(BuildingDto buildingDto);

    BuildingDto save(BuildingCreateDto buildingDto);

    boolean delete(BuildingDto buildingDto);

    List<BuildingDto> getAll();
    List<BuildingDto> getAllByIds(List<Long> ids);

    List<BuildingDto> getByPropertiesList(List<Long> propertiesIds);

    List<Long> findAllByBuildingPropertiesIsIn(SearchRequestDto searchRequestDto);
}
