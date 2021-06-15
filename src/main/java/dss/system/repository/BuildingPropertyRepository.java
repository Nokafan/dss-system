package dss.system.repository;

import dss.system.entity.BuildingProperty;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingPropertyRepository extends JpaRepository<BuildingProperty, Long> {
//    BuildingProperty save(BuildingProperty buildingProperty);
//
//    Optional<BuildingProperty> findById(Long id);
//
//    void deleteById(Long id);
}
