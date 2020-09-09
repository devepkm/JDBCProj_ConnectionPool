package com.devepkm.test;

import com.devepkm.bean.StudentResult;
import com.devepkm.dao.StudentResultDAOImp;
import com.devepkm.utils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentResultDAOImpTest {

    @Test
    void getAllResult() {
        StudentResultDAOImp studentResultDAOImp = new StudentResultDAOImp();
        List<StudentResult> s = studentResultDAOImp.getAllResult(JDBCUtils.getConnection());
        for (StudentResult ss : s){
            System.out.println(ss);
        }

    }
}