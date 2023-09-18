package org.example.mapper.dtos;

import lombok.Builder;
import org.example.domain.models.Student;
import org.example.domain.models.Subject;

@Builder

public record GradesDto(
        Long gradesId,
        Student student,
        Subject subject,
        double grade,
        String corte) {
    public GradesDto(Long gradesId, double grade, String corte) {
        this(gradesId, null, null, grade, corte);
    }
}
