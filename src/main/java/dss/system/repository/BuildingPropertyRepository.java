package dss.system.repository;

import dss.system.entity.BuildingProperty;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingPropertyRepository extends JpaRepository<BuildingProperty, Long> {

    List<BuildingProperty> findAllByTitle_Id(Long id);

    @Query(value = "SELECT pv.id FROM property_variations pv "
            + "WHERE pv.title_id = :propertyId AND pv.value IN :variations", nativeQuery = true)
    List<Long> findBuildingPropertiesIdByVariations(@Param("propertyId") Long propertyId,
                                                    @Param("variations") List<String> variations);

    @Query("SELECT DISTINCT bp.value FROM BuildingProperty bp WHERE bp.title.id = :id")
    List<String> getDistinctBuildingPropertyVariations(Long id);
}
