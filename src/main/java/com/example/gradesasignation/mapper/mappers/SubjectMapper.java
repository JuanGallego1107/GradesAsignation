package org.example.mapper.mappers;

import org.example.domain.models.Subject;
import org.example.domain.models.Teacher;
import org.example.mapper.dtos.SubjectDto;
import org.example.mapper.dtos.TeacherDto;

import java.util.List;

public class SubjectMapper {
    public static SubjectDto mapFrom(Subject source){
        return new SubjectDto(source.getId(),
                source.getName(),
                source.getTeachers());
    }
    public static Subject mapFrom(SubjectDto source){
        return new Subject(source.subjectId(),
                source.subjectName(),
                source.teacher());
    }
    public static List<SubjectDto> mapFrom(List<Subject> source) {
        return source.parallelStream().map(e-> mapFrom(e)).toList();
    }
}
