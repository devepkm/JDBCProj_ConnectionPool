package com.devepkm.dao;

import com.devepkm.bean.Result;
import com.devepkm.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;

public class ResultDAOImp {


    private BeanHandler<Result> handler;

    public Result getResult(Connection conn, String sql, Object... args) {

        QueryRunner runner = new QueryRunner();
        BeanHandler<Result>handler = new BeanHandler<>(Result.class);
        Result rs = null;
        try {
            rs = runner.query(JDBCUtils.getConnection(), sql, handler,args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rs;

    }
}
