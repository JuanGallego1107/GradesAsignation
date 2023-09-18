package org.example.service.impl;

import org.example.mapper.dtos.StudentDto;
import org.example.repository.Impl.StudentRepositoryImpl;
import org.example.repository.StudentRepository;
import org.example.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    StudentRepository repo = new StudentRepositoryImpl();
    @Override
    public List<StudentDto> studentList() {
        return repo.studentList();
    }

    @Override
    public StudentDto byId(Long id) {
        return repo.byId(id);
    }

    @Override
    public void update(StudentDto student) {
        repo.update(student);
    }

    @Override
    public void delete(Long id) {
        repo.delete(id);
    }
}
