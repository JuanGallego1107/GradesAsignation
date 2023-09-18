package com.example.gradesasignation.repository.Impl;

import com.example.gradesasignation.domain.models.Student;
import com.example.gradesasignation.exceptions.UniversityException;
import com.example.gradesasignation.mapper.dtos.StudentDto;
import com.example.gradesasignation.mapper.mappers.StudentMapper;
import com.example.gradesasignation.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryLogicImpl implements StudentRepository {

    private List<Student> students;

    public StudentRepositoryLogicImpl() {
        Student s1 = new Student(1L,"Andrea","andre@gmail.com","Enfermeria","II");
        Student s2 = new Student(2L,"Andrea","andre@gmail.com","Enfermeria","II");
        Student s3 = new Student(3L,"Andrea","andre@gmail.com","Enfermeria","II");
        students = new ArrayList<>(List.of(s1,s2,s3));
    }

    @Override
    public List<StudentDto> studentList() {
        return StudentMapper.mapFrom(students);
    }

    @Override
    public StudentDto byId(Long id) {
        return students.stream()
                .filter(e->e.getId().equals(e.getId()))
                .findFirst()
                .map(StudentMapper::mapFrom)
                .orElseThrow(()-> new UniversityException("Student not found"));
    }

    @Override
    public void update(StudentDto student) {
        students.add(StudentMapper.mapFrom(student));
    }

    @Override
    public void delete(Long id) {
        students.removeIf(e->e.getId().equals(id));
    }
}
