package peaksoft.spring_boot_rest_api.mapper.StudentMapper;

import org.springframework.stereotype.Component;
import peaksoft.spring_boot_rest_api.dto.StudentDto.StudentResponse;
import peaksoft.spring_boot_rest_api.models.Student;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentViewMapper {

    public StudentResponse viewStudent(Student student) {

        if (student == null) {

            return null;

        }

        return StudentResponse.builder()

                .id(student.getId())

                .name(student.getName())

                .email(student.getEmail())

                .isActive(student.getIsActive())

                .created(student.getCreated())

                .build();

    }


    public List<StudentResponse> view(List<Student> students){

        List<StudentResponse> responses = new ArrayList<>();

        for (Student student: students) {

            responses.add(viewStudent(student));

        }

        return responses;

    }
}
