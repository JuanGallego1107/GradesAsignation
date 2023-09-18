package org.example.service.impl;

import org.example.mapper.dtos.TeacherDto;
import org.example.repository.Impl.TeacherRepositoryImpl;
import org.example.repository.TeacherRepository;
import org.example.service.TeacherService;

import java.util.List;

public class TeacherServiceImpl implements TeacherService {

    TeacherRepository repo =  new TeacherRepositoryImpl();
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
