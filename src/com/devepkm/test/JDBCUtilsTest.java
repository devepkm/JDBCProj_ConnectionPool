package com.devepkm.test;

import com.devepkm.utils.JDBCUtils;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class JDBCUtilsTest {

    @org.junit.jupiter.api.Test
    void getConnection() throws Exception {
        Connection conn = JDBCUtils.getConnection();
        System.out.println(conn);
    }
}