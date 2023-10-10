/*package com.example.gradesasignation.repository.logic;

import com.example.gradesasignation.domain.models.Teacher;
import com.example.gradesasignation.exceptions.UniversityException;
import com.example.gradesasignation.mapper.dtos.TeacherDto;
import com.example.gradesasignation.mapper.mappers.StudentMapper;
import com.example.gradesasignation.mapper.mappers.TeacherMapper;
import com.example.gradesasignation.repository.TeacherRepository;

import java.util.ArrayList;
import java.util.List;

public class TeacherRepositoryLogicImpl implements TeacherRepository {

    private List<Teacher> teachers;

    public TeacherRepositoryLogicImpl() {
        Teacher t1 = new Teacher(1L,"Carlos Arias","casArias34@gmail.com");
        Teacher t2 = new Teacher(2L,"Matias Montero","mati2538@gmail.com");
        Teacher t3 = new Teacher(3L,"Maria Zuluaga","zuluMa11@gmail.com");
        teachers = new ArrayList<>(List.of(t1,t2,t3));
    }

    @Override
    public List<TeacherDto> teacherList() {
        return TeacherMapper.mapFrom(teachers);
    }

    @Override
    public TeacherDto byId(Long id) {
        return teachers.stream()
                .filter(e->e.getId().equals(e.getId()))
                .findFirst()
                .map(TeacherMapper::mapFrom)
                .orElseThrow(()-> new UniversityException("Teacher not found"));
    }

    @Override
    public void update(TeacherDto teacher) {
        teachers.add(TeacherMapper.mapFrom(teacher));
    }

    @Override
    public void delete(Long id) {
        teachers.removeIf(e->e.getId().equals(id));
    }
}
*/