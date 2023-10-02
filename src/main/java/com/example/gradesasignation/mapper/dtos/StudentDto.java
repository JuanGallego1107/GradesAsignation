package com.example.gradesasignation.mapper.dtos;

import lombok.Builder;

@Builder
public record StudentDto(
        Long studentId,
        String studentName,
        String studentEmail,
        String degree,
        String semester) {

}