package com.devepkm.dao;

import com.devepkm.bean.Student;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentDAOImp {

    public boolean verify(Connection conn, String sql, Student s) {
        Object[] args = new Object[4];
        args[0] = s.getHkid();
        args[1] = s.getName();
        args[2] = s.getBirth();
        args[3] = s.getAdmissionID();
        QueryRunner runner = new QueryRunner();
        ResultSetHandler rsHandler = new ResultSetHandler() {
            @Override
            public Object handle(ResultSet rs) throws SQLException {
                return rs.next();
            }
        };
        try {
            return (boolean) runner.query(conn, sql, rsHandler, args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;


    }

    public List<Student> getAllStudent(Connection conn) {

        String sql = "select HKID hkid, Name name, Birth birth, AdmissionID admissionID  from student";
        QueryRunner runner = new QueryRunner();
        BeanListHandler<Student> beanListHandler = new BeanListHandler<>(Student.class);
        try {
            return runner.query(conn, sql, beanListHandler);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

}
