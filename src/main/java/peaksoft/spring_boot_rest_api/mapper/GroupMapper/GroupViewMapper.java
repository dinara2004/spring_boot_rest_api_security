package peaksoft.spring_boot_rest_api.mapper.GroupMapper;

import org.springframework.stereotype.Component;
import peaksoft.spring_boot_rest_api.dto.GroupDto.GroupResponse;
import peaksoft.spring_boot_rest_api.models.Group;

import java.util.ArrayList;
import java.util.List;

@Component
public class GroupViewMapper {

    public GroupResponse viewGroup(Group group) {

        if (group == null) {

            return null;

        }

        return GroupResponse.builder()

                .id(group.getId())

                .groupName(group.getGroupName())

                .dateOfStart(group.getDateOfStart())

                .dateOfFinish(group.getDateOfFinish())

                .isActive(group.getIsActive())

                .created(group.getCreated())

                .build();

    }

    public List<GroupResponse> view(List<Group> groups){

        List<GroupResponse> responses = new ArrayList<>();

        for (Group group: groups) {

            responses.add(viewGroup(group));

        }

        return responses;

    }
}
