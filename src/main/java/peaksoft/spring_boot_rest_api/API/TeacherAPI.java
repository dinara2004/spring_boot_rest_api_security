package peaksoft.spring_boot_rest_api.API;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import peaksoft.spring_boot_rest_api.dto.TeacherDto.TeacherRequest;
import peaksoft.spring_boot_rest_api.dto.TeacherDto.TeacherResponse;
import peaksoft.spring_boot_rest_api.service.CourseService;
import peaksoft.spring_boot_rest_api.service.TeacherService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/teacher")
public class TeacherAPI {

    private final TeacherService teacherService;

    private final CourseService courseService;

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping("/create/{courseId}")
    public TeacherResponse create(@PathVariable Long courseId,
                                  @RequestBody TeacherRequest request){

        courseService.findById(courseId);

        return teacherService.create(request);

    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PutMapping("{id}")
    public TeacherResponse update(@PathVariable Long id,
                                  @RequestBody TeacherRequest request){

        return teacherService.update(id, request);

    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'TEACHER', 'STUDENT')")
    @GetMapping("{id}")
    public TeacherResponse findById(@PathVariable Long id){

        return teacherService.findById(id);

    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @DeleteMapping("{id}")
    public TeacherResponse delete(@PathVariable Long id){

        return teacherService.deleteById(id);

    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'TEACHER', 'STUDENT')")
    @GetMapping
    public List<TeacherResponse> getAllTeachers(){

        return teacherService.getAllTeachers();

    }
}
