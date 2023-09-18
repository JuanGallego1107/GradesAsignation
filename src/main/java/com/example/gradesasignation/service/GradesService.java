package com.example.gradesasignation.service;

import com.example.gradesasignation.mapper.dtos.GradesDto;

import java.util.List;

public interface GradesService {
    List<GradesDto> gradesList();
    GradesDto byId(Long id);
    void update(GradesDto grades);

    void delete(Long id);
}
