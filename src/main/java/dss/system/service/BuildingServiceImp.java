package dss.system.service;

import dss.system.dto.BuildingDto;
import dss.system.entity.Building;
import dss.system.repository.BuildingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuildingServiceImp implements BuildingService{
    private final ModelMapper modelMapper;
    private final BuildingRepository buildingRepository;

    @Autowired
    public BuildingServiceImp(ModelMapper modelMapper, BuildingRepository buildingRepository) {
        this.modelMapper = modelMapper;
        this.buildingRepository = buildingRepository;
    }

    @Override
    public Building save(Building building) {
        return buildingRepository.save(building);
    }

    @Override
    public Building save(BuildingDto buildingDto) {
        Building newBuilding = modelMapper.map(buildingDto,Building.class);
        return buildingRepository.save(newBuilding);
    }

    @Override
    public void delete(Building building) {
        buildingRepository.delete(building);
    }

    @Override
    public void delete(BuildingDto buildingDto) {
        Building newBuilding = modelMapper.map(buildingDto,Building.class);
        buildingRepository.delete(newBuilding);
    }


}
