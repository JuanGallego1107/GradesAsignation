package com.example.gradesasignation.mapper.mappers;



import com.example.gradesasignation.domain.models.Subject;
import com.example.gradesasignation.mapper.dtos.SubjectDto;

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
