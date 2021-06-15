package dss.system.repository;

import dss.system.entity.Property;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
//    Property save(Property property);
//
//    List<Property> saveAll(List<Property> propertyList);
//
//    Optional<Property> findById(Long id);
//
//    void deleteById(Long id);
}
