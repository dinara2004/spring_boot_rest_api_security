package peaksoft.spring_boot_rest_api.dto.TeacherDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherRequest {

    private String firstName;

    private String email;

    private String lastName;
}
