package com.example.gradesasignation.service;



import com.example.gradesasignation.mapper.dtos.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> studentList();
    StudentDto byId(Long id);
    void update(StudentDto student);

    void delete(Long id);
}
