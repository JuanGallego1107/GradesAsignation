package org.example.service.impl;

import org.example.mapper.dtos.GradesDto;
import org.example.repository.GradesRepository;
import org.example.repository.Impl.GradesRepositoryImpl;
import org.example.service.GradesService;

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
