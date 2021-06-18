package dss.system.controller;

import dss.system.dto.BuildingDto;
import dss.system.dto.CreateBuildingDto;
import dss.system.dto.SearchBuildingRequestDto;
import dss.system.service.BuildingService;
import dss.system.service.SearchService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/building")
public class BuildingController {
    private final BuildingService buildingService;
    private final SearchService searchService;

    @Autowired
    public BuildingController(BuildingService buildingService,
                              SearchService searchService) {
        this.buildingService = buildingService;
        this.searchService = searchService;
    }

    @PostMapping("/")
    public BuildingDto saveBuilding(@Valid @RequestBody CreateBuildingDto buildingDto) {
        return buildingService.save(buildingDto);
    }

    @DeleteMapping("/")
    public ResponseEntity deleteBuilding(@Valid @RequestBody BuildingDto buildingDto) {
        boolean result = buildingService.delete(buildingDto);
        return result ? new ResponseEntity(HttpStatus.OK)
                : new ResponseEntity(HttpStatus.CONFLICT);
    }

    @GetMapping("/")
    public ResponseEntity<List<BuildingDto>> getAllBuildings() {
        List<BuildingDto> buildingDtoList = buildingService.getAll();
        return new ResponseEntity<>(buildingDtoList, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<BuildingDto>> getAllBuildingsById(@RequestBody List<Long> ids) {
        List<BuildingDto> buildingDtoList = buildingService.getAllByIds(ids);
        return new ResponseEntity<>(buildingDtoList, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<BuildingDto>> getByPropertiesList(
            @RequestBody SearchBuildingRequestDto searchRequestDto) {
        List<BuildingDto> buildingDtoList =
                searchService.findBuildingsByListParams(searchRequestDto);
        return new ResponseEntity<>(buildingDtoList, HttpStatus.OK);
    }
}
