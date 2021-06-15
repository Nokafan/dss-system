package dss.system.repository;

import dss.system.entity.Building;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {
    @Query(value = "SELECT b FROM Building b WHERE b.buildingProperties IN :propertiesIds")
    List<Building> getAllByBuildingPropertiesIsIn(@Param("propertiesIds") List<Long> propertiesIds);
}
