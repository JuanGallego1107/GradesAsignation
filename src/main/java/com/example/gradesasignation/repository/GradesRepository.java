package org.example.repository;

import org.example.mapper.dtos.GradesDto;
import org.example.mapper.dtos.StudentDto;

import java.util.List;

public interface GradesRepository {
    List<GradesDto> gradesList();
    GradesDto byId(Long id);
    void update(GradesDto grades);

    void delete(Long id);
}
