package com.devepkm.test;

import com.devepkm.bean.Result;
import com.devepkm.dao.ResultDAOImp;
import com.devepkm.utils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class ResultDAOImpTest {

    @Test
    void getResult() {
        Connection conn = JDBCUtils.getConnection();
        String sql = "Select HKID hkid, Chinese chinese, English english, Maths maths, LiberalStudies liberalStudies from result where `HKID` = ?";
        Object[] args = new Object[1];
        args[0] = new String("Y583039(a)");
        Result rs = new Result();
        ResultDAOImp temp = new ResultDAOImp();


        Result instance = temp.getResult(conn, sql, args);
        System.out.println(instance);

        JDBCUtils.closeResource(conn, null, null);
    }
}