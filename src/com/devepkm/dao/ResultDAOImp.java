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


    public Result getResult(Connection conn, String sql, Object... args) {

        QueryRunner runner = new QueryRunner();
        BeanHandler<Result> handler = new BeanHandler<>(Result.class);
        Result rs = null;
        try {
            rs = runner.query(JDBCUtils.getConnection(), sql, handler, args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rs;

    }

    public void modifyResult(Connection conn, String hkid, Result rs) {
        String sql = "UPDATE result SET chinese = ?, english = ?, maths = ?, LiberalStudies = ?  WHERE hkid = ?;";
        Object[] args = new Object[5];
        args[0] = rs.getChinese();
        args[1] = rs.getEnglish();
        args[2] = rs.getMaths();
        args[3] = rs.getLiberalStudies();
        args[4] = hkid;
        QueryRunner runner = new QueryRunner();
        try {
            runner.update(conn,sql,args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


}
