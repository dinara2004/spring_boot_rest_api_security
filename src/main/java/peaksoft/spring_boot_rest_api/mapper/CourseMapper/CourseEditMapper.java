package peaksoft.spring_boot_rest_api.mapper.CourseMapper;

import org.springframework.stereotype.Component;
import peaksoft.spring_boot_rest_api.dto.CourseDto.CourseRequest;
import peaksoft.spring_boot_rest_api.models.Course;

import java.time.LocalDate;

@Component
public class CourseEditMapper {

    public Course create(CourseRequest request) {

        if (request == null) {

            return null;

        }

        Course course = new Course();

        course.setName(request.getName());

        course.setDuration(request.getDuration());

        course.setCreated(LocalDate.now());

        course.setIsActive(true);

        return course;

    }

    public void update(Course course,
                       CourseRequest courseRequest) {

        course.setName(courseRequest.getName());

        course.setDuration(courseRequest.getDuration());

    }
}
