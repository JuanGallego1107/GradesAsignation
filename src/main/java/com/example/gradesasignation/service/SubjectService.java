package org.example.service;

import org.example.mapper.dtos.SubjectDto;

import java.util.List;

public interface SubjectService {
    List<SubjectDto> subjectList();
    SubjectDto byId(Long id);
    void update(SubjectDto subject);

    void delete(Long id);
}
