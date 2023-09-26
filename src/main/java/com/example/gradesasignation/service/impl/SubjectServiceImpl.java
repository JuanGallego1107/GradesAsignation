package com.example.gradesasignation.service.impl;



import com.example.gradesasignation.mapper.dtos.SubjectDto;
import com.example.gradesasignation.repository.Impl.StudentRepositoryImpl;
import com.example.gradesasignation.repository.Impl.SubjectRepositoryImpl;
import com.example.gradesasignation.repository.Impl.SubjectRepositoryLogicImpl;
import com.example.gradesasignation.repository.Impl.TeacherRepositoryLogicImpl;
import com.example.gradesasignation.repository.SubjectRepository;
import com.example.gradesasignation.service.SubjectService;

import java.sql.Connection;
import java.util.List;

public class SubjectServiceImpl implements SubjectService {
    private SubjectRepository repo;

    public SubjectServiceImpl(Connection connection) {
        this.repo = new SubjectRepositoryImpl(connection);
    }

    @Override
    public List<SubjectDto> subjectList() {
        return repo.subjectList();
    }

    @Override
    public SubjectDto byId(Long id) {
        return repo.byId(id);
    }

    @Override
    public void update(SubjectDto subject) {
        repo.update(subject);
    }

    @Override
    public void delete(Long id) {
        repo.delete(id);
    }
}
