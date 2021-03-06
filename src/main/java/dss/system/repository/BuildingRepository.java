package dss.system.repository;

import dss.system.entity.Building;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {

    @Query(value = "select b.id from building b "
            + "join building_properties bp "
            + "on b.id = bp.building_id "
            + "where b.id in (:buildingId) and bp.building_properties_id in "
            + "(:buildingPropertiesId)", nativeQuery = true)
    List<Long> findAllByBuildingPropertiesIsIn(
            @Param("buildingId") List<Long> buildingId,
            @Param("buildingPropertiesId") List<Long> buildingPropertiesId);
}
