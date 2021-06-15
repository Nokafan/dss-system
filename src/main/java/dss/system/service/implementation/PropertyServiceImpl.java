package dss.system.service.implementation;

import dss.system.dto.PropertyDto;
import dss.system.entity.Property;
import dss.system.exceptions.DataProcessingException;
import dss.system.repository.PropertyRepository;
import dss.system.service.PropertyService;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PropertyServiceImpl implements PropertyService {
    private final ModelMapper modelMapper;
    private final PropertyRepository propertyRepository;

    @Autowired
    public PropertyServiceImpl(ModelMapper modelMapper,
                               PropertyRepository propertyRepository) {
        this.modelMapper = modelMapper;
        this.propertyRepository = propertyRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public PropertyDto save(PropertyDto propertyDto) {
        Property property = modelMapper.map(propertyDto, Property.class);
        Property savedProperty = propertyRepository.save(property);
        return modelMapper.map(savedProperty, PropertyDto.class);
    }

    @Override
    public List<PropertyDto> saveAll(List<PropertyDto> propertyDtoList) {
        List<Property> propertyList = propertyDtoList.stream()
                .map(propertyDto -> modelMapper.map(propertyDto, Property.class))
                .collect(Collectors.toList());
        List<PropertyDto> propertyDtos = propertyRepository.saveAll(propertyList)
                .stream()
                .map(property -> modelMapper.map(property, PropertyDto.class))
                .collect(Collectors.toList());
        return propertyDtos;
    }

    @Override
    public PropertyDto findById(Long id) {
        return propertyRepository.findById(id)
                .map(entity -> modelMapper.map(entity, PropertyDto.class))
                .orElseThrow(() -> new DataProcessingException("Can`t get propertyDto by id: " + id));
    }

    @Override
    public void deleteById(Long id) {
        propertyRepository.deleteById(id);
    }

    @Override
    public List<PropertyDto> findAll() {
        return propertyRepository.findAll()
                .stream()
                .map(property -> modelMapper.map(property, PropertyDto.class))
                .collect(Collectors.toList());
    }
}
