package dss.system.controller;


import dss.system.dto.PropertyDto;
import dss.system.service.PropertyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
}
