package peaksoft.spring_boot_rest_api.dto.CourseDto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import peaksoft.spring_boot_rest_api.models.Company;
import peaksoft.spring_boot_rest_api.models.Group;
import peaksoft.spring_boot_rest_api.models.Teacher;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
public class CourseResponse {

    private Long id;

    private String name;

    private LocalDate duration;

    private int size;

    private LocalDate created;

    private Boolean isActive;

}
