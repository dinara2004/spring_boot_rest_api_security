package peaksoft.spring_boot_rest_api.mapper.TeacherMapper;

import org.springframework.stereotype.Component;
import peaksoft.spring_boot_rest_api.dto.TeacherDto.TeacherResponse;
import peaksoft.spring_boot_rest_api.models.Teacher;

import java.util.ArrayList;
import java.util.List;

@Component
public class TeacherViewMapper {

    public TeacherResponse viewTeacher(Teacher teacher) {

        if (teacher == null) {

            return null;

        }

        return TeacherResponse.builder()

                .id(teacher.getId())

                .firstName(teacher.getFirstName())

                .email(teacher.getEmail())

                .lastName(teacher.getLastName())

                .isActive(teacher.getIsActive())

                .created(teacher.getCreated())

                .build();
    }

    public List<TeacherResponse> view(List<Teacher> teachers){

        List<TeacherResponse> responses = new ArrayList<>();

        for (Teacher teacher: teachers) {

            responses.add(viewTeacher(teacher));

        }

        return responses;

    }

}
