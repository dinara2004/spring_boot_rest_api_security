package peaksoft.spring_boot_rest_api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.spring_boot_rest_api.dto.GroupDto.GroupRequest;
import peaksoft.spring_boot_rest_api.dto.GroupDto.GroupResponse;
import peaksoft.spring_boot_rest_api.models.Group;
import peaksoft.spring_boot_rest_api.mapper.GroupMapper.GroupEditMapper;
import peaksoft.spring_boot_rest_api.mapper.GroupMapper.GroupViewMapper;
import peaksoft.spring_boot_rest_api.repository.GroupRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository repository;

    private final GroupEditMapper editMapper;

    private final GroupViewMapper viewMapper;

    public GroupResponse create(GroupRequest groupRequest){

        Group group = editMapper.create(groupRequest);

        repository.save(group);

        return viewMapper.viewGroup(group);

    }

    public GroupResponse update(Long id,
                                GroupRequest groupRequest){

        Group group = repository.findById(id).get();

        editMapper.update(group, groupRequest);

        return viewMapper.viewGroup(repository.save(group));

    }

    public GroupResponse findById(Long id){

        Group group = repository.findById(id).get();

        return viewMapper.viewGroup(group);

    }

    public GroupResponse deleteById(Long id){

        Group group = repository.getById(id);

        repository.delete(group);

        return viewMapper.viewGroup(group);

    }

    public List<GroupResponse> getAllGroups(){

        return viewMapper.view(repository.findAll());

    }
}
