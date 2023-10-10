package com.example.gradesasignation.service.impl;



import com.example.gradesasignation.mapper.dtos.TeacherDto;
import com.example.gradesasignation.repository.TeacherRepository;
import com.example.gradesasignation.service.TeacherService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class TeacherServiceImpl implements TeacherService {
    @Inject
    private TeacherRepository repo;

    @Override
    public List<TeacherDto> teacherList() {
        return repo.teacherList();
    }

    @Override
    public TeacherDto byId(Long id) {
        return repo.byId(id);
    }

    @Override
    public void update(TeacherDto teacher) {
        repo.update(teacher);
    }

    @Override
    public void delete(Long id) {
        repo.delete(id);
    }
}
