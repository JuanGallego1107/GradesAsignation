package com.example.gradesasignation.service;



import com.example.gradesasignation.mapper.dtos.TeacherDto;

import java.util.List;

public interface TeacherService {
    List<TeacherDto> teacherList();
    TeacherDto byId(Long id);
    void update(TeacherDto teacher);

    void delete(Long id);
}
