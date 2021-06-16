package dss.system.service.implementation;

import dss.system.dto.BuildingCreateDto;
import dss.system.dto.BuildingDto;
import dss.system.dto.SearchRequestDto;
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
    public BuildingServiceImp(ModelMapper modelMapper, BuildingRepository buildingRepository) {
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
    public BuildingDto save(BuildingCreateDto buildingDto) {
        Building newBuilding = modelMapper.map(buildingDto, Building.class);
        buildingRepository.save(newBuilding);
        return modelMapper.map(newBuilding, BuildingDto.class);
    }

    @Override
    public boolean delete(BuildingDto buildingDto) {
        Building newBuilding = modelMapper.map(buildingDto, Building.class);
        buildingRepository.delete(newBuilding);
        return !buildingRepository.findById(buildingDto.getId()).isPresent();
    }

    @Override
    public List<BuildingDto> getAll() {
        return buildingRepository.findAll()
                .stream()
                .map(building -> modelMapper.map(building, BuildingDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<BuildingDto> getAllByIds(List<Long> ids) {
        return buildingRepository.findAllById(ids)
                .stream()
                .map(building -> modelMapper.map(building, BuildingDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<Long> findAllByBuildingPropertiesIsIn(SearchRequestDto searchRequestDto) {
        return buildingRepository.findAllByBuildingPropertiesIsIn(searchRequestDto.getBuildingId(),
                                                        searchRequestDto.getPropertiesIds());
    }
}
