package peaksoft.spring_boot_rest_api.mapper.CourseMapper;

import org.springframework.stereotype.Component;
import peaksoft.spring_boot_rest_api.dto.CourseDto.CourseResponse;
import peaksoft.spring_boot_rest_api.models.Course;

import java.util.ArrayList;
import java.util.List;

@Component
public class CourseViewMapper {

    public CourseResponse viewCourse(Course course) {

        if (course == null) {

            return null;

        }

        return CourseResponse.builder()

                .id(course.getId())

                .name(course.getName())

                .duration(course.getDuration())

                .created(course.getCreated())

                .isActive(course.getIsActive())

                .build();
    }

    public List<CourseResponse> view(List<Course> courses){

        List<CourseResponse> responses = new ArrayList<>();

        for (Course course: courses) {

            responses.add(viewCourse(course));

        }

        return responses;

    }
}
