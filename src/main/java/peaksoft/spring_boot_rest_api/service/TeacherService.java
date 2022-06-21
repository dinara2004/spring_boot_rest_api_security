package peaksoft.spring_boot_rest_api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.spring_boot_rest_api.dto.TeacherDto.TeacherRequest;
import peaksoft.spring_boot_rest_api.dto.TeacherDto.TeacherResponse;
import peaksoft.spring_boot_rest_api.models.Teacher;
import peaksoft.spring_boot_rest_api.mapper.TeacherMapper.TeacherEditMapper;
import peaksoft.spring_boot_rest_api.mapper.TeacherMapper.TeacherViewMapper;
import peaksoft.spring_boot_rest_api.repository.TeacherRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository repository;

    private final TeacherEditMapper editMapper;

    private final TeacherViewMapper viewMapper;

    public TeacherResponse create(TeacherRequest teacherRequest){

        Teacher teacher = editMapper.create(teacherRequest);

        repository.save(teacher);

        return viewMapper.viewTeacher(teacher);

    }

    public TeacherResponse update(Long id,
                                  TeacherRequest teacherRequest){

        Teacher teacher = repository.findById(id).get();

        editMapper.update(teacher, teacherRequest);

        return viewMapper.viewTeacher(repository.save(teacher));

    }

    public TeacherResponse findById(Long id){

        Teacher teacher = repository.findById(id).get();

        return viewMapper.viewTeacher(teacher);

    }

    public TeacherResponse deleteById(Long id){

        Teacher teacher = repository.getById(id);

        repository.delete(teacher);

        return viewMapper.viewTeacher(teacher);

    }

    public List<TeacherResponse> getAllTeachers(){

        return viewMapper.view(repository.findAll());

    }
}

