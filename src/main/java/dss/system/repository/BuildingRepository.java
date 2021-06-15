package dss.system.repository;

import dss.system.entity.Building;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {
//    Building save(Building building);
//
//    Optional<Building> findById(Long id);
//
//    void deleteById(Long id);
}
