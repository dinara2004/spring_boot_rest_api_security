package peaksoft.spring_boot_rest_api.dto.GroupDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupRequest {

    private String groupName;

    private String dateOfStart;

    private String  dateOfFinish;

}
