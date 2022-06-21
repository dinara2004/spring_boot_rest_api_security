package peaksoft.spring_boot_rest_api.mapper.GroupMapper;

import org.springframework.stereotype.Component;
import peaksoft.spring_boot_rest_api.dto.GroupDto.GroupRequest;
import peaksoft.spring_boot_rest_api.models.Group;

import java.time.LocalDate;

@Component
public class GroupEditMapper {

    public Group create(GroupRequest request) {

        if (request == null) {

            return null;

        }

        Group group = new Group();

        group.setGroupName(request.getGroupName());

        group.setDateOfStart(request.getDateOfStart());

        group.setDateOfFinish(request.getDateOfFinish());

        group.setCreated(LocalDate.now());

        group.setIsActive(true);

        return group;

    }

    public void update(Group group,
                       GroupRequest groupRequest) {

        group.setGroupName(groupRequest.getGroupName());

        group.setDateOfStart(groupRequest.getDateOfStart());

        group.setDateOfFinish(groupRequest.getDateOfFinish());

    }
}

