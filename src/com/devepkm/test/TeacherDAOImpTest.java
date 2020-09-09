package com.devepkm.test;

import com.devepkm.dao.TeacherDAOImp;
import com.devepkm.utils.JDBCUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeacherDAOImpTest {

    @Test
    void verifyTeacher() {
        TeacherDAOImp t = new TeacherDAOImp();
        String sql = "SELECT ID id, Password password from teacher where id = ? AND password = ?";
        Object[] args = new Object[2];
        String id = "1";
        String password = "1";
        args[0] = id;
        args[1] = password;
        System.out.println(t.verifyTeacher(JDBCUtils.getConnection(), sql, args));
        System.out.println("...........................");
        password = "aa";
        args[1] = password;
        System.out.println(t.verifyTeacher(JDBCUtils.getConnection(), sql, args));
    }
}