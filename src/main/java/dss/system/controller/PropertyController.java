package dss.system.controller;

import dss.system.dto.CreatePropertyDto;
import dss.system.dto.PropertyDto;
import dss.system.service.PropertyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/property")
public class PropertyController {
    private final PropertyService propertyService;

    @Autowired
    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping("/")
    public ResponseEntity<List<PropertyDto>> getAllProperty() {
        List<PropertyDto> propertyDtoList = propertyService.findAll();
        return new ResponseEntity<>(propertyDtoList, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<PropertyDto> createProperty(
            @RequestBody CreatePropertyDto createPropertyDto) {
        PropertyDto propertyDto = propertyService.save(createPropertyDto);
        return new ResponseEntity<>(propertyDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropertyDto> getById(@PathVariable Long id) {
        PropertyDto propertyDto = propertyService.findById(id);
        return new ResponseEntity<>(propertyDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        propertyService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
