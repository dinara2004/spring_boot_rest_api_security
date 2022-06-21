package peaksoft.spring_boot_rest_api.mapper.TeacherMapper;

import org.springframework.stereotype.Component;
import peaksoft.spring_boot_rest_api.dto.TeacherDto.TeacherRequest;
import peaksoft.spring_boot_rest_api.models.Teacher;

import java.time.LocalDate;

@Component
public class TeacherEditMapper {

    public Teacher create(TeacherRequest request) {

        if (request == null) {

            return null;

        }

        Teacher teacher = new Teacher();

        teacher.setFirstName(request.getFirstName());

        teacher.setEmail(request.getEmail());

        teacher.setLastName(request.getLastName());

        teacher.setCreated(LocalDate.now());

        teacher.setIsActive(true);

        return teacher;

    }

    public void update(Teacher teacher,
                       TeacherRequest teacherRequest) {

        teacher.setFirstName(teacherRequest.getFirstName());

        teacher.setEmail(teacherRequest.getEmail());

        teacher.setLastName(teacherRequest.getLastName());

    }
}
