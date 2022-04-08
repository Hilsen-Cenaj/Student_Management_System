package com.example.student_management_system.student;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(final ResultSet resultSet, final int i) throws SQLException {
        final Student student = new Student();
        student.setId(resultSet.getLong(1));
        student.setUserName(resultSet.getString(2));
        student.setEmail(resultSet.getString(3));
        student.setPassword(resultSet.getString(4));

        return student;
    }
}
