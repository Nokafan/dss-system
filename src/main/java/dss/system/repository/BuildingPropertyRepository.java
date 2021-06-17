package dss.system.repository;

import dss.system.entity.BuildingProperty;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingPropertyRepository extends JpaRepository<BuildingProperty, Long> {
    List<BuildingProperty> getAllByTitle_Id(Long id);

    List<BuildingProperty> findAllByTitle_Id(Long id);

    @Query(value = "SELECT pv.id from property_variations pv " +
            "where pv.title_id = :propertyId and pv.value like :variation", nativeQuery = true)
    List<Long> findByVariations(@Param("propertyId") Long propertyId,
                                @Param("variation") String variation);

    @Query("SELECT DISTINCT bp.value from BuildingProperty bp WHERE bp.title.id = :id")
    List<String> getBuildingPropertyVariations(Long id);
}
