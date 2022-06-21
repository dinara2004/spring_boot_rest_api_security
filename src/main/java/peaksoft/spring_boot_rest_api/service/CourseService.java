package peaksoft.spring_boot_rest_api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.spring_boot_rest_api.dto.CourseDto.CourseRequest;
import peaksoft.spring_boot_rest_api.dto.CourseDto.CourseResponse;
import peaksoft.spring_boot_rest_api.models.Course;
import peaksoft.spring_boot_rest_api.mapper.CourseMapper.CourseEditMapper;
import peaksoft.spring_boot_rest_api.mapper.CourseMapper.CourseViewMapper;
import peaksoft.spring_boot_rest_api.repository.CourseRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository repository;

    private final CourseEditMapper editMapper;

    private final CourseViewMapper viewMapper;


    public CourseResponse create(CourseRequest courseRequest){

        Course course = editMapper.create(courseRequest);

        repository.save(course);

        return viewMapper.viewCourse(course);

    }

    public CourseResponse update(Long id,
                                 CourseRequest courseRequest){

        Course course = repository.findById(id).get();

        editMapper.update(course, courseRequest);

        return viewMapper.viewCourse(repository.save(course));

    }

    public CourseResponse findById(Long id){

        Course course = repository.findById(id).get();

        return viewMapper.viewCourse(course);

    }



    public CourseResponse deleteById(Long id){

        Course course = repository.getById(id);

        repository.delete(course);

        return viewMapper.viewCourse(course);

    }

    public List<CourseResponse> getAllCourses(){

        return viewMapper.view(repository.findAll());

    }
}
