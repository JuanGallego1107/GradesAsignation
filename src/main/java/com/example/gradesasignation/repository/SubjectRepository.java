package com.example.gradesasignation.repository;



import com.example.gradesasignation.mapper.dtos.SubjectDto;

import java.util.List;

public interface SubjectRepository {
    List<SubjectDto> subjectList();
    SubjectDto byId(Long id);
    void update(SubjectDto subject);

    void delete(Long id);
}
