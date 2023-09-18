package com.example.gradesasignation.repository;



import com.example.gradesasignation.mapper.dtos.StudentDto;

import java.util.List;

public interface  StudentRepository {
    List<StudentDto> studentList();
    StudentDto byId(Long id);
    void update(StudentDto student);

    void delete(Long id);
}
