package com.example.gradesasignation.repository.Impl;


import com.example.gradesasignation.annotations.MysqlConn;
import com.example.gradesasignation.domain.models.Teacher;
import com.example.gradesasignation.exceptions.ServiceJdbcException;
import com.example.gradesasignation.mapper.dtos.TeacherDto;
import com.example.gradesasignation.mapper.mappers.TeacherMapper;
import com.example.gradesasignation.repository.TeacherRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class TeacherRepositoryImpl implements TeacherRepository {
    @Inject
    @MysqlConn
    private Connection conn;

    private Teacher createTeacher(ResultSet rs) throws SQLException {
        Teacher teacher = new Teacher();
        teacher.setId(rs.getLong("id"));
        teacher.setName(rs.getString("name"));
        teacher.setEmail(rs.getString("email"));
        return teacher;
    }
    @Override
    public List<TeacherDto> teacherList() {
        List<Teacher> teacherList = new ArrayList<>();

        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * from teachers")) {
            while (resultSet.next()) {
                Teacher teacher = createTeacher(resultSet);
                teacherList.add(teacher);
            }
        } catch (SQLException throwables) {
            throw new ServiceJdbcException(throwables.getMessage(),
                    throwables.getCause());
        }
        return TeacherMapper.mapFrom(teacherList);
    }

    @Override
    public TeacherDto byId(Long id) {
        Teacher teacher = null;
        try (PreparedStatement preparedStatement = conn
                .prepareStatement("SELECT * FROM teachers WHERE id = ?")) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                teacher = createTeacher(resultSet);
            }
            resultSet.close();
        } catch (SQLException throwables) {
            throw new ServiceJdbcException(throwables.getMessage(),
                    throwables.getCause());
        }
        return TeacherMapper.mapFrom(teacher);
    }

    @Override
    public void update(TeacherDto teacher) {
        String sql;
        if (teacher.teacherId() != null && teacher.teacherId()>0) {
            sql = "UPDATE teachers SET name=?, email=? WHERE id=?";
        } else {
            sql = "INSERT INTO teachers (name, email) VALUES(?,?)";
        }
        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, teacher.teacherName());

            if (teacher.teacherId() != null && teacher.teacherId()>0 ){
                stmt.setString(2, teacher.teacherEmail());
                stmt.setLong(3, teacher.teacherId());
            } else {
                stmt.setString(2, teacher.teacherEmail());
            }
            stmt.executeUpdate();

        } catch (SQLException throwables) {
            throw new ServiceJdbcException(throwables.getMessage(),
                    throwables.getCause());
        }
    }

    @Override
    public void delete(Long id) {
        try(PreparedStatement stmt = conn.prepareStatement("DELETE FROM teachers WHERE id =?")){
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throw new ServiceJdbcException(throwables.getMessage(),
                    throwables.getCause());
        }
    }
}
