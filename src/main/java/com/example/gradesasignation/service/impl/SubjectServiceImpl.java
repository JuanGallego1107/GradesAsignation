package org.example.service.impl;

import org.example.mapper.dtos.SubjectDto;
import org.example.repository.Impl.SubjectRepositoryImpl;
import org.example.repository.SubjectRepository;
import org.example.service.SubjectService;

import java.util.List;

public class SubjectServiceImpl implements SubjectService {
    SubjectRepository repo = new SubjectRepositoryImpl();

    @Override
    public List<SubjectDto> subjectList() {
        return repo.subjectList();
    }

    @Override
    public SubjectDto byId(Long id) {
        return repo.byId(id);
    }

    @Override
    public void update(SubjectDto subject) {
        repo.update(subject);
    }

    @Override
    public void delete(Long id) {
        repo.delete(id);
    }
}
