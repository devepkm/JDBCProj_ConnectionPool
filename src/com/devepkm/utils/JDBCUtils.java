package com.devepkm.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static DataSource source;


    public static Connection getConnection() {
        if (source == null) {
            InputStream is = null;
            try {
                is = JDBCUtils.class.getClassLoader().getResourceAsStream("com/devepkm/dbResource/config.properties");
                Properties pros = new Properties();
                pros.load(is);
                source = DruidDataSourceFactory.createDataSource(pros);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
        try {
            return source.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            return null;
        }

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
