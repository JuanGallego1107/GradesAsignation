package com.example.gradesasignation.service;


import com.example.gradesasignation.mapper.dtos.SubjectDto;

import java.util.List;

public interface SubjectService {
    List<SubjectDto> subjectList();
    SubjectDto byId(Long id);
    void update(SubjectDto subject);

    void delete(Long id);
}
