package com.example.gradesasignation.service.impl;


import com.example.gradesasignation.mapper.dtos.StudentDto;
import com.example.gradesasignation.repository.Impl.StudentRepositoryImpl;
import com.example.gradesasignation.repository.Impl.StudentRepositoryLogicImpl;
import com.example.gradesasignation.repository.StudentRepository;
import com.example.gradesasignation.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private final StudentRepositoryLogicImpl repo;

    public StudentServiceImpl(StudentRepositoryLogicImpl repo) {
        this.repo = repo;
    }

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
