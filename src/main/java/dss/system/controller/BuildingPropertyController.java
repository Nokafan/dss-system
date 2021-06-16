package dss.system.controller;

import dss.system.dto.BuildingPropertyDto;
import dss.system.service.BuildingPropertyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/building/property")
public class BuildingPropertyController {
    private final BuildingPropertyService buildingPropertyService;

    @Autowired
    public BuildingPropertyController(BuildingPropertyService buildingPropertyService) {
        this.buildingPropertyService = buildingPropertyService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<BuildingPropertyDto>> getPropertyVariations(@PathVariable Long id) {
        List<BuildingPropertyDto> variationsByTitleId =
                buildingPropertyService.getVariationsByTitleId(id);
        return new ResponseEntity<>(variationsByTitleId, HttpStatus.OK);
    }
}
