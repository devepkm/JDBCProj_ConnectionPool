package com.devepkm.dao;

import com.devepkm.bean.StudentResult;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class StudentResultDAOImp {
    public List<StudentResult> getAllResult(Connection conn){

        String sql = "select student.HKID hkid, Name name, Birth birth, AdmissionID admissionID, Chinese chinese, English english, Maths maths, LiberalStudies liberalStudies from student, result where student.HKID = result.HKID";
        QueryRunner runner = new QueryRunner();
        BeanListHandler<StudentResult> rsHandler= new BeanListHandler<>(StudentResult.class);
        try {
            return runner.query(conn, sql, rsHandler);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;

    }
}
