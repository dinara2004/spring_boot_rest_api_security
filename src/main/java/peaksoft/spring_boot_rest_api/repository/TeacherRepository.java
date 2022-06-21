package peaksoft.spring_boot_rest_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.spring_boot_rest_api.models.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}