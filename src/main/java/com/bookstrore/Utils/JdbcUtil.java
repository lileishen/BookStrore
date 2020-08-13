package com.bookstrore.Utils;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.FileReader;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;


public class JdbcUtil {
    private static DruidDataSource dataSource=null;
    static Connection conn = null;
    static{
        try {
          //  InputStream is = ClassLoader.getSystemResourceAsStream("druid.properties");
           InputStream is =JdbcUtil.class.getClassLoader().getResourceAsStream("/druid.properties");
            Properties properties = new Properties();
            properties.load(is);
           /* ClassLoader classLoader = JdbcUtil.class.getClassLoader();
            URL  url =classLoader.getResource("druid.properties");
            String path =url.getPath();
            properties.load(new FileReader(path));*/
            dataSource  = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    /**
    * 获取数据库连接
    *
    * @return
    */
    public static Connection getConnections() {

        try {
            conn = dataSource.getConnection();
        } catch (Exception e) {
            System.out.println("数据源没找到");
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭数据库连接
     *
     * @param conn
     */
    public static void closeResourses(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
