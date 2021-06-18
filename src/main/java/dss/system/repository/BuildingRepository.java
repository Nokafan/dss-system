package dss.system.repository;

import dss.system.entity.Building;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {

    @Query(value = "SELECT * FROM building b "
            + "JOIN building_properties bp "
            + "ON b.id = bp.building_id "
            + "WHERE b.id IN (:buildingId) AND bp.building_properties_id IN "
            + "(:buildingPropertiesId)", nativeQuery = true)
    List<Building> findAllBuildingsByBuildingPropertiesIsIn(
            @Param("buildingId") List<Long> buildingId,
            @Param("buildingPropertiesId") List<Long> buildingPropertiesId);
}
