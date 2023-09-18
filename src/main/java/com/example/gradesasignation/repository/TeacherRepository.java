package com.example.gradesasignation.repository;



import com.example.gradesasignation.mapper.dtos.TeacherDto;

import java.util.List;

public interface TeacherRepository {
    List<TeacherDto> teacherList();
    TeacherDto byId(Long id);
    void update(TeacherDto teacher);

    void delete(Long id);
}
