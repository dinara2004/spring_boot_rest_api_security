package peaksoft.spring_boot_rest_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.spring_boot_rest_api.models.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
