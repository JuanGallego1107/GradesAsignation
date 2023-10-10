package com.example.gradesasignation.service.impl;


import com.example.gradesasignation.mapper.dtos.GradesDto;
import com.example.gradesasignation.repository.GradesRepository;
import com.example.gradesasignation.service.GradesService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class GradesServiceImpl implements GradesService {
    @Inject
    private GradesRepository repo;

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
