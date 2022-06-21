package peaksoft.spring_boot_rest_api.API;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import peaksoft.spring_boot_rest_api.dto.GroupDto.GroupRequest;
import peaksoft.spring_boot_rest_api.dto.GroupDto.GroupResponse;
import peaksoft.spring_boot_rest_api.service.CourseService;
import peaksoft.spring_boot_rest_api.service.GroupService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/group")
public class GroupAPI {

    private final GroupService groupService;

    private final CourseService courseService;

    @PreAuthorize("hasAnyAuthority('ADMIN', 'TEACHER')")
    @PostMapping("/create/{courseId}")
    public GroupResponse create(@PathVariable Long courseId,
                                @RequestBody GroupRequest request){

        courseService.findById(courseId);

        return groupService.create(request);

    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'TEACHER')")
    @PutMapping("{id}")
    public GroupResponse update(@PathVariable Long id,
                                @RequestBody GroupRequest request){

        return groupService.update(id, request);

    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'TEACHER', 'STUDENT')")
    @GetMapping("{id}")
    public GroupResponse findById(@PathVariable Long id){

        return groupService.findById(id);

    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'TEACHER')")
    @DeleteMapping("{id}")
    public GroupResponse delete(@PathVariable Long id){

        return groupService.deleteById(id);

    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'TEACHER', 'STUDENT')")
    @GetMapping
    public List<GroupResponse> getAllGroups(){

        return groupService.getAllGroups();

    }
}
