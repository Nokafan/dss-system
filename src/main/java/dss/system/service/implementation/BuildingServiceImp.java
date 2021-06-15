package dss.system.service.implementation;

import dss.system.dto.BuildingDto;
import dss.system.entity.Building;
import dss.system.repository.BuildingRepository;
import dss.system.service.BuildingService;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuildingServiceImp implements BuildingService {
    private final ModelMapper modelMapper;
    private final BuildingRepository buildingRepository;

    @Autowired
    public BuildingServiceImp(ModelMapper modelMapper,
                              BuildingRepository buildingRepository) {
        this.modelMapper = modelMapper;
        this.buildingRepository = buildingRepository;
    }

    @Override
    public BuildingDto save(BuildingDto buildingDto) {
        Building newBuilding = modelMapper.map(buildingDto, Building.class);
        buildingRepository.save(newBuilding);
        return modelMapper.map(newBuilding, BuildingDto.class);
    }

    @Override
    public void delete(BuildingDto buildingDto) {
        Building newBuilding = modelMapper.map(buildingDto, Building.class);
        buildingRepository.delete(newBuilding);
    }

    @Override
    public List<BuildingDto> getAll() {
        return buildingRepository.findAll()
                .stream()
                .map(building -> modelMapper.map(building, BuildingDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<BuildingDto> getByPropertiesList(List<Long> propertiesIds) {
        return buildingRepository.findByBuildingPropertiesIn(propertiesIds)
                .stream()
                .map(building -> modelMapper.map(building, BuildingDto.class))
                .collect(Collectors.toList());
    }
}
