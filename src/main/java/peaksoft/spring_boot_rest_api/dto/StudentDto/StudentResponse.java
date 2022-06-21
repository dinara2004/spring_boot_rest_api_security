package peaksoft.spring_boot_rest_api.dto.StudentDto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import peaksoft.spring_boot_rest_api.models.Group;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class StudentResponse {

    private Long id;

    private String name;

    private String email;

    private LocalDate created;

    private Boolean isActive;

}
