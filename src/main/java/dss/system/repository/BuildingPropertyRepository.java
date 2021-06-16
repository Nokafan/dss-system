package dss.system.repository;

import dss.system.entity.BuildingProperty;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingPropertyRepository extends JpaRepository<BuildingProperty, Long> {
    List<BuildingProperty> getAllByTitle_Id(Long id);
}
