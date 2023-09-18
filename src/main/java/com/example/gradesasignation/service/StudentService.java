package org.example.service;

import org.example.mapper.dtos.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> studentList();
    StudentDto byId(Long id);
    void update(StudentDto student);

    void delete(Long id);
}
