package peaksoft.spring_boot_rest_api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.spring_boot_rest_api.dto.StudentDto.StudentRequest;
import peaksoft.spring_boot_rest_api.dto.StudentDto.StudentResponse;
import peaksoft.spring_boot_rest_api.models.Student;
import peaksoft.spring_boot_rest_api.mapper.StudentMapper.StudentEditMapper;
import peaksoft.spring_boot_rest_api.mapper.StudentMapper.StudentViewMapper;
import peaksoft.spring_boot_rest_api.repository.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    private final StudentEditMapper editMapper;

    private final StudentViewMapper viewMapper;

    public StudentResponse create(StudentRequest studentRequest){

        Student student = editMapper.create(studentRequest);

        repository.save(student);

        return viewMapper.viewStudent(student);

    }

    public StudentResponse update(Long id,
                                  StudentRequest studentRequest){

        Student student = repository.findById(id).get();

        editMapper.update(student, studentRequest);

        return viewMapper.viewStudent(repository.save(student));

    }

    public StudentResponse findById(Long id){

        Student student = repository.findById(id).get();

        return viewMapper.viewStudent(student);

    }

    public StudentResponse deleteById(Long id){

        Student student = repository.getById(id);

        repository.delete(student);

        return viewMapper.viewStudent(student);

    }

    public List<StudentResponse> getAllStudents(){

        return viewMapper.view(repository.findAll());

    }
 }
