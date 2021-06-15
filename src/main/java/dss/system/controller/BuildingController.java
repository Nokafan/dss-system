package dss.system.controller;

import dss.system.dto.BuildingDto;
import dss.system.entity.Building;
import dss.system.service.BuildingService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/building")
public class BuildingController {
    private final BuildingService buildingService;

    @Autowired
    public BuildingController(BuildingService buildingService) {
        this.buildingService = buildingService;
    }

    @PostMapping("/")
    public BuildingDto saveBuilding(@Valid @RequestBody BuildingDto buildingDto){
        return buildingService.save(buildingDto);
    }
    @DeleteMapping("/")
    public ResponseEntity deleteBuilding(@Valid @RequestBody BuildingDto buildingDto){
        buildingService.delete(buildingDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<BuildingDto>> getAllBuildings() {
        List<BuildingDto> buildingDtoList = buildingService.getAll();
        return new ResponseEntity<>(buildingDtoList, HttpStatus.OK);
    }

    @GetMapping("/properties")
    public ResponseEntity<List<BuildingDto>> getByPropertiesList(@RequestBody List<Long> propertiesIds) {
        List<BuildingDto> buildingDtoList = buildingService.getByPropertiesList(propertiesIds);
//        return new ResponseEntity<>(buildingDtoList, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
