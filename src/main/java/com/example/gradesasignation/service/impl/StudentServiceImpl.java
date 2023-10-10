package com.example.gradesasignation.service.impl;


import com.example.gradesasignation.mapper.dtos.StudentDto;
import com.example.gradesasignation.repository.StudentRepository;
import com.example.gradesasignation.service.StudentService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class StudentServiceImpl implements StudentService {
    @Inject
    private StudentRepository repo;

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
