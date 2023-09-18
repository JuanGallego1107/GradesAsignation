package com.example.gradesasignation.mapper.dtos;


public record StudentDto(
        Long studentId,
        String studentName,
        String studentEmail,
        String degree,
        String semester) {

}