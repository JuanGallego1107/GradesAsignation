package com.example.gradesasignation.service.impl;



import com.example.gradesasignation.mapper.dtos.GradesDto;
import com.example.gradesasignation.repository.GradesRepository;
import com.example.gradesasignation.repository.Impl.GradesRepositoryImpl;
import com.example.gradesasignation.service.GradesService;

import java.util.List;

public class GradesServiceImpl implements GradesService {

    GradesRepository repo = new GradesRepositoryImpl();
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
