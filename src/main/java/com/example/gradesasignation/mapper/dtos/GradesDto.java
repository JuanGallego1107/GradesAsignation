package com.example.gradesasignation.mapper.dtos;

import com.example.gradesasignation.domain.models.Student;
import com.example.gradesasignation.domain.models.Subject;
import lombok.Builder;

@Builder
public record GradesDto(
        Long gradesId,
        Student student,
        Subject subject,
        double grade,
        String corte) {
}
