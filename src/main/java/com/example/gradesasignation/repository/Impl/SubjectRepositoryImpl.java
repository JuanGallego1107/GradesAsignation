package com.example.gradesasignation.repository.Impl;


import com.example.gradesasignation.annotations.MysqlConn;
import com.example.gradesasignation.domain.models.Subject;
import com.example.gradesasignation.domain.models.Teacher;
import com.example.gradesasignation.mapper.dtos.SubjectDto;
import com.example.gradesasignation.mapper.mappers.SubjectMapper;
import com.example.gradesasignation.repository.SubjectRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class SubjectRepositoryImpl implements SubjectRepository {

    @Inject
    @MysqlConn
    private Connection conn;

    private Subject createSubject(ResultSet rs) throws SQLException {
        Subject subject = new Subject();
        subject.setId(rs.getLong("id"));
        subject.setName(rs.getString("name"));

        Teacher teacher = new Teacher();
        teacher.setId(rs.getLong("teacher_id"));
        teacher.setName(rs.getString("teacher_name"));
        teacher.setEmail(rs.getString("email"));
        subject.setTeachers(teacher);

        return subject;
    }

    @Override
    public List<SubjectDto> subjectList() {
        List<Subject> subjectList = new ArrayList<>();

        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT sb.*, th.name as teacher_name, th.email " +
                     "FROM subjects sb " +
                     "JOIN teachers th ON sb.teacher_id = th.id ;" )) {
            while (resultSet.next()) {
                Subject subject = createSubject(resultSet);
                subjectList.add(subject);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return SubjectMapper.mapFrom(subjectList);
    }

    @Override
    public SubjectDto byId(Long id) {
        Subject subject = null;
        try (PreparedStatement preparedStatement = conn
                .prepareStatement("SELECT sb.*, th.name as teacher_name, th.email " +
                        "FROM subjects sb " +
                        "JOIN teachers th ON sb.teacher_id = th.id " +
                        "WHERE sb.id=?;")) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                subject = createSubject(resultSet);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return SubjectMapper.mapFrom(subject);
    }

    @Override
    public void update(SubjectDto subject) {
        String sql;
        if (subject.subjectId() != null && subject.subjectId()>0) {
            sql = "UPDATE subjects SET name=? WHERE id=?";
        } else {
            sql = "INSERT INTO subjects (name) VALUES(?)";
        }
        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, subject.subjectName());

            if (subject.subjectId() != null && subject.subjectId()>0) {
                stmt.setLong(2, subject.subjectId());
            }
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void delete(Long id) {
        try(PreparedStatement stmt = conn.prepareStatement("DELETE FROM subjects WHERE id =?")){
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
