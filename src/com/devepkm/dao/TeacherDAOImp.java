package com.devepkm.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherDAOImp {
    public boolean verifyTeacher(Connection conn, String sql, Object... args) {
        QueryRunner runner = new QueryRunner();
        ResultSetHandler rsHandler = new ResultSetHandler() {
            @Override
            public Object handle(ResultSet rs) throws SQLException {
                return rs.next();
            }
        };
        try {
            return (boolean) runner.query(conn, sql, rsHandler,args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;


    }
}
