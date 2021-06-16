package dss.system.service.implementation;

import dss.system.dto.BuildingPropertyDto;
import dss.system.entity.BuildingProperty;
import dss.system.exceptions.DataProcessingException;
import dss.system.repository.BuildingPropertyRepository;
import dss.system.service.BuildingPropertyService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuildingPropertyServiceImpl implements BuildingPropertyService {
    private final ModelMapper modelMapper;
    private final BuildingPropertyRepository buildingPropertyRepository;

    @Autowired
    public BuildingPropertyServiceImpl(ModelMapper modelMapper,
                                       BuildingPropertyRepository buildingPropertyRepository) {
        this.modelMapper = modelMapper;
        this.buildingPropertyRepository = buildingPropertyRepository;
    }

    @Override
    public BuildingPropertyDto save(BuildingPropertyDto buildingPropertyDto) {
        BuildingProperty buildingProperty = modelMapper.map(buildingPropertyDto, BuildingProperty.class);
        buildingPropertyRepository.save(buildingProperty);
        return modelMapper.map(buildingProperty, BuildingPropertyDto.class);
    }

    @Override
    public BuildingPropertyDto findById(Long id) {
        BuildingProperty buildingProperty = buildingPropertyRepository.findById(id)
                .orElseThrow(() -> new DataProcessingException("Couldn`t find BuildingProperty by id: " + id));
        return modelMapper.map(buildingProperty, BuildingPropertyDto.class);
    }


    @Override
    public List<BuildingPropertyDto> getVariationsByTitleId(long id) {
        return buildingPropertyRepository.getAllByTitle_Id(id)
                .stream()
                .map(buildingProperty -> modelMapper.map(buildingProperty, BuildingPropertyDto.class))
                .collect(Collectors.toList());
    }
}
