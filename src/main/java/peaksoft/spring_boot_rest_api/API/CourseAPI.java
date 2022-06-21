package peaksoft.spring_boot_rest_api.API;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import peaksoft.spring_boot_rest_api.dto.CourseDto.CourseRequest;
import peaksoft.spring_boot_rest_api.dto.CourseDto.CourseResponse;
import peaksoft.spring_boot_rest_api.service.CompanyService;
import peaksoft.spring_boot_rest_api.service.CourseService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/course")
public class CourseAPI {

    private final CourseService courseService;

    private final CompanyService companyService;

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping("/create/{companyId}")
    public CourseResponse create(@RequestBody CourseRequest request,
                                 @PathVariable Long companyId){

        companyService.findById(companyId);

        return courseService.create(request);

    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PutMapping("/update{id}")
    public CourseResponse update(@PathVariable Long id,
                                 @RequestBody CourseRequest request){

        return courseService.update(id, request);

    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'TEACHER', 'STUDENT')")
    @GetMapping("/find/{id}")
    public CourseResponse findById(@PathVariable Long id){

        return courseService.findById(id);

    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public CourseResponse delete(@PathVariable Long id){

        return courseService.deleteById(id);

    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'TEACHER', 'STUDENT')")
    @GetMapping
    public List<CourseResponse> getAllCourses(){

        return courseService.getAllCourses();

    }
}
