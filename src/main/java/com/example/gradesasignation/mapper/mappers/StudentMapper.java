package org.example.mapper.mappers;

import org.example.domain.models.Student;
import org.example.mapper.dtos.StudentDto;

import java.util.List;

public class StudentMapper {
    public static StudentDto mapFrom(Student source){
        return new StudentDto(source.getId(),
                source.getName(),
                source.getEmail(),
                source.getDegree(),
                source.getSemester());
    }
    public static Student mapFrom(StudentDto source){
        return new Student(source.studentId(),
                source.studentName(),
                source.studentEmail(),
                source.degree(),
                source.semester());
    }
    public static List<StudentDto> mapFrom(List<Student> source) {
        return source.parallelStream().map(e-> mapFrom(e)).toList();
    }
}
