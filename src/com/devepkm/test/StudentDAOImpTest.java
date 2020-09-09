package com.devepkm.test;

import com.devepkm.bean.Student;
import com.devepkm.dao.StudentDAOImp;
import com.devepkm.utils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentDAOImpTest {

    @Test
    void verify() throws ParseException {
        StudentDAOImp stdDAO = new StudentDAOImp();
        String sDate1="1996-10-24";
        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);
        java.sql.Date pdate = new java.sql.Date(date1.getTime());
        String sql = "SELECT HKID hkid, Name name, Birth birth, AdmissionID admissionID FROM student WHERE HKID = ? AND Name = ? AND Birth = ? AND AdmissionID = ?";
        Student temp = new Student("Y094039(0)", "崔祖英",  pdate, "1546235551");

        System.out.println(stdDAO.verify(JDBCUtils.getConnection(), sql, temp));
        System.out.println("...........................");
        String sDate2="1996-10-24";
        Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);
        java.sql.Date pdate2 = new java.sql.Date(date1.getTime());
        Student temp2 = new Student("Y094039(0) ", "崔祖英",  pdate2, "1546235551");
        System.out.println(stdDAO.verify(JDBCUtils.getConnection(), sql, temp2));

    }

    @Test
    void getAllStudent() throws SQLException {
        StudentDAOImp stdDAO = new StudentDAOImp();
        Connection conn = JDBCUtils.getConnection();
        List<Student> students = stdDAO.getAllStudent(conn);
        for (Student s : students){
            System.out.println(s);
        }
        JDBCUtils.closeResource(conn,null,null);
    }
}