package com.example.gradesasignation.service.impl;



import com.example.gradesasignation.mapper.dtos.TeacherDto;
import com.example.gradesasignation.repository.Impl.TeacherRepositoryImpl;
import com.example.gradesasignation.repository.Impl.TeacherRepositoryLogicImpl;
import com.example.gradesasignation.repository.TeacherRepository;
import com.example.gradesasignation.service.TeacherService;

import java.util.List;

public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepositoryLogicImpl repo;

    public TeacherServiceImpl(TeacherRepositoryLogicImpl repo){
        this.repo = repo;
    }
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
