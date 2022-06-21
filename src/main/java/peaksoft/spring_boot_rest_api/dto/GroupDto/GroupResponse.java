package peaksoft.spring_boot_rest_api.dto.GroupDto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class GroupResponse {

    private Long id;

    private String groupName;

    private String dateOfStart;

    private String  dateOfFinish;

    private int size;

    private LocalDate created;

    private Boolean isActive;
}
