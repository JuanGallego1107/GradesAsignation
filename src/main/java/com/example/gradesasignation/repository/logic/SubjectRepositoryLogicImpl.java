/*package com.example.gradesasignation.repository.logic;

import com.example.gradesasignation.domain.models.Subject;
import com.example.gradesasignation.domain.models.Teacher;
import com.example.gradesasignation.exceptions.UniversityException;
import com.example.gradesasignation.mapper.dtos.SubjectDto;
import com.example.gradesasignation.mapper.mappers.SubjectMapper;
import com.example.gradesasignation.mapper.mappers.TeacherMapper;
import com.example.gradesasignation.repository.SubjectRepository;

import java.util.ArrayList;
import java.util.List;

public class SubjectRepositoryLogicImpl implements SubjectRepository {

    private List<Subject> subjects;

    public SubjectRepositoryLogicImpl(){
        Subject sb1 = new Subject(1L,"Matematicas I",
                new Teacher(1L,"Carlos Arias","casArias34@gmail.com"));
        Subject sb2 = new Subject(2L,"Programacion",
                new Teacher(2L,"Matias Montero","mati2538@gmail.com"));
        Subject sb3 = new Subject(3L,"Analisis numerico",
                new Teacher(3L,"Maria Zuluaga","zuluMa11@gmail.com"));
        subjects = new ArrayList<>(List.of(sb1,sb2,sb3));
    }

    @Override
    public List<SubjectDto> subjectList() {
        return SubjectMapper.mapFrom(subjects);
    }

    @Override
    public SubjectDto byId(Long id) {
        return subjects.stream()
                .filter(e->e.getId().equals(e.getId()))
                .findFirst()
                .map(SubjectMapper::mapFrom)
                .orElseThrow(()-> new UniversityException("Subject not found"));
    }

    @Override
    public void update(SubjectDto subject) {
        subjects.add(SubjectMapper.mapFrom(subject));
    }

    @Override
    public void delete(Long id) {
        subjects.removeIf(e -> e.getId().equals(id));
    }
}
*/