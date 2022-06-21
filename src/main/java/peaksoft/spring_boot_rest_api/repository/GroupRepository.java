package peaksoft.spring_boot_rest_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.spring_boot_rest_api.models.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {
}