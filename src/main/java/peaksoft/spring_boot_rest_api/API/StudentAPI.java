package peaksoft.spring_boot_rest_api.API;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import peaksoft.spring_boot_rest_api.dto.StudentDto.StudentRequest;
import peaksoft.spring_boot_rest_api.dto.StudentDto.StudentResponse;
import peaksoft.spring_boot_rest_api.service.GroupService;
import peaksoft.spring_boot_rest_api.service.StudentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/student")
public class StudentAPI {

    private final StudentService studentService;

    private final GroupService groupService;

    @PreAuthorize("hasAnyAuthority('ADMIN', 'TEACHER')")
    @PostMapping("/create/{groupId}")
    public StudentResponse create(@PathVariable Long groupId,
                                  @RequestBody StudentRequest request){

        groupService.findById(groupId);

        return studentService.create(request);

    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'TEACHER')")
    @PutMapping("{id}")
    public StudentResponse update(@PathVariable Long id,
                                  @RequestBody StudentRequest request){

        return studentService.update(id, request);

    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'TEACHER', 'STUDENT')")
    @GetMapping("{id}")
    public StudentResponse findById(@PathVariable Long id){

        return studentService.findById(id);

    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'TEACHER')")
    @DeleteMapping("{id}")
    public StudentResponse delete(@PathVariable Long id){

        return studentService.deleteById(id);

    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'TEACHER', 'STUDENT')")
    @GetMapping
    public List<StudentResponse> getAllStudents(){

        return studentService.getAllStudents();

    }
}
