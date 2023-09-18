package org.example.service;

import org.example.mapper.dtos.GradesDto;

import java.util.List;

public interface GradesService {
    List<GradesDto> gradesList();
    GradesDto byId(Long id);
    void update(GradesDto grades);

    void delete(Long id);
}
