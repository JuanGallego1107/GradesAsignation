package org.example.repository;

import org.example.domain.models.Student;
import org.example.mapper.dtos.StudentDto;

import java.util.List;

public interface  StudentRepository {
    List<StudentDto> studentList();
    StudentDto byId(Long id);
    void update(StudentDto student);

    void delete(Long id);
}
