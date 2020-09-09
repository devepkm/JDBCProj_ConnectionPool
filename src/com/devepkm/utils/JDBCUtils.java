package com.devepkm.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static DataSource source;

    public static Connection getConnection () throws Exception {
        if (source == null){
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("com/devepkm/dbResource/config.properties");
            Properties pros = new Properties();
            pros.load(is);
            source = DruidDataSourceFactory.createDataSource(pros);


        }

        return source.getConnection();
    }

    public static void closeResource(Connection conn, Statement ps, ResultSet rs) {

        try {
            DbUtils.close(conn);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            DbUtils.close(ps);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            DbUtils.close(rs);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
