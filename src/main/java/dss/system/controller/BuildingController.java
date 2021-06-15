package dss.system.controller;

import dss.system.dto.BuildingDto;
import dss.system.entity.Building;
import dss.system.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    BuildingDto getEmptyBuilding(){
        return new BuildingDto();
    }
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Building saveBuilding(@RequestBody BuildingDto buildingDto){
        return buildingService.save(buildingDto);
    }
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    ResponseEntity deleteBuilding(@RequestBody BuildingDto buildingDto){
        buildingService.delete(buildingDto);
        return new ResponseEntity(HttpStatus.OK);
    }


}
