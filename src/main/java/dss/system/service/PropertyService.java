package dss.system.service;

import dss.system.dto.CreatePropertyDto;
import dss.system.dto.PropertyDto;
import dss.system.dto.SearchBuildingPropertyDto;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface PropertyService {
    PropertyDto save(PropertyDto property);

    PropertyDto save(CreatePropertyDto createPropertyDto);

    List<PropertyDto> saveAll(List<PropertyDto> propertyDtoList);

    PropertyDto findById(Long id);

    void deleteById(Long id);

    List<PropertyDto> findAll();
}

