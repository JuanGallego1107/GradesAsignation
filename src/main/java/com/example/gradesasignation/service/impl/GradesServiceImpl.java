package com.example.gradesasignation.service.impl;



import com.example.gradesasignation.mapper.dtos.GradesDto;
import com.example.gradesasignation.repository.GradesRepository;
import com.example.gradesasignation.repository.Impl.GradesRepositoryImpl;
import com.example.gradesasignation.repository.Impl.StudentRepositoryImpl;
import com.example.gradesasignation.repository.StudentRepository;
import com.example.gradesasignation.service.GradesService;

import java.sql.Connection;
import java.util.List;

public class GradesServiceImpl implements GradesService {

    private GradesRepository repo;

    public GradesServiceImpl(Connection connection) {
        this.repo = new GradesRepositoryImpl(connection);
    }
    @Override
    public List<GradesDto> gradesList() {
        return repo.gradesList();
    }

    @Override
    public GradesDto byId(Long id) {
       return repo.byId(id);
    }

    @Override
    public void update(GradesDto grades) {
       repo.update(grades);
    }

    @Override
    public void delete(Long id) {
        repo.delete(id);
    }
}
