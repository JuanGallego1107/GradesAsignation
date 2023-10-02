package com.example.gradesasignation.mapper.dtos;

import com.example.gradesasignation.domain.models.Student;
import com.example.gradesasignation.domain.models.Subject;
import lombok.Builder;

@Builder
public record GradesDto(
        Long gradesId,
        Student student,
        Subject subject,
        Double grade,
        String corte) {

    public GradesDto(Long gradesId, Double grade, String corte) {
        this(gradesId, null, null, grade, corte);
    }
}
