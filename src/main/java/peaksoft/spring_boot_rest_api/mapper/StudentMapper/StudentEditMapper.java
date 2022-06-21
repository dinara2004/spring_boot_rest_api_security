package peaksoft.spring_boot_rest_api.mapper.StudentMapper;

import org.springframework.stereotype.Component;
import peaksoft.spring_boot_rest_api.dto.StudentDto.StudentRequest;
import peaksoft.spring_boot_rest_api.models.Student;

import java.time.LocalDate;

@Component
public class StudentEditMapper {

    public Student create(StudentRequest request) {

        if (request == null) {

            return null;

        }

        Student student = new Student();

        student.setName(request.getName());

        student.setEmail(request.getEmail());

        student.setCreated(LocalDate.now());

        student.setIsActive(true);

        return student;

    }

    public void update(Student student,
                       StudentRequest studentRequest) {

        student.setName(studentRequest.getName());

        student.setEmail(studentRequest.getEmail());

    }
}
