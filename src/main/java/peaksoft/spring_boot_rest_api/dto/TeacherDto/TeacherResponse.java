package peaksoft.spring_boot_rest_api.dto.TeacherDto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import peaksoft.spring_boot_rest_api.models.Course;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class TeacherResponse {

    private Long id;

    private String firstName;

    private String email;

    private String lastName;

    private LocalDate created;

    private Boolean isActive;
}
