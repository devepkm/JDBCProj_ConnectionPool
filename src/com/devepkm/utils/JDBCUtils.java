package com.devepkm.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
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

}
