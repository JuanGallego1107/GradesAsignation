package org.example.repository;

import org.example.domain.models.Teacher;
import org.example.mapper.dtos.SubjectDto;
import org.example.mapper.dtos.TeacherDto;

import java.util.List;

public interface TeacherRepository {
    List<TeacherDto> teacherList();
    TeacherDto byId(Long id);
    void update(TeacherDto teacher);

    void delete(Long id);
}
