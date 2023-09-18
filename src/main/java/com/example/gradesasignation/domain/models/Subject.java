package org.example.domain.models;

import org.example.domain.enums.Semester;

import java.util.List;

public class Subject {
    private Long id;
    private String name;
    private Teacher teachers;

    public Subject(Long id, String name, Teacher teachers) {
        this.id = id;
        this.name = name;
        this.teachers = teachers;
    }

    public Subject() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeachers() {
        return teachers;
    }

    public void setTeachers(Teacher teachers) {
        this.teachers = teachers;
    }



    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teachers=" + teachers +
                '}';
    }
}
