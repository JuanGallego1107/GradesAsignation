package org.example.mapper.mappers;

import org.example.domain.models.Grades;
import org.example.mapper.dtos.GradesDto;

import java.util.List;

public class GradesMapper {
    public static GradesDto mapFrom(Grades source) {
        return new GradesDto(source.getId(),
                source.getStudent(),
                source.getSubject(),
                source.getGrade(),
                source.getCorte());
    }

    public static Grades mapFrom(GradesDto source){
        return new Grades(source.gradesId(),
                source.student(),
                source.subject(),
                source.grade(),
                source.corte());
    }

    public static List<GradesDto> mapFrom(List<Grades> sources){
        return sources.parallelStream().map(e-> mapFrom(e)).toList();
    }
}
