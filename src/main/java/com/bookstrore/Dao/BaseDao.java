package com.bookstrore.Dao;

import com.bookstrore.Utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author nono
 * @Package com.bookstrore.Dao
 * @ClassName BaseDao.java
 * @Description TODO
 * @createTime 2020年08月10日 14:55:00
 */
public abstract class BaseDao {
    //使用DButils 操作数据库
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * update () 方法用来执行增删改
     */
    public int update(String sql, Object ...args) {
        Connection conn = JdbcUtil.getConnections();
        try {
            return queryRunner.update(conn, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.closeResourses(conn);
        }
        return -1;
    }

    /**
     *  查询返回一条数据
     * @param sql 执行的SQL语句
     * @param type  返回的对象类型
     * @param args  sql 对应的参数值
     * @param <T>  返回的类型泛型
     * @return
     */
    public <T>  T queryForOne(String sql,Class<T> type, Object... args){
        Connection conn =JdbcUtil.getConnections();
        try {
          return  queryRunner.query(conn,sql,new BeanHandler<>(type),args);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.closeResourses(conn);
        }
        return null;
    }

    /**
     * 查询返回多条数据
     * @param sql
     * @param type
     * @param args
     * @param <T>
     * @return
     */
    public <T> List<T> queryForList(String sql, Class<T> type, Object... args){
        Connection conn =JdbcUtil.getConnections();
        try {
          return  queryRunner.query(conn,sql,new BeanListHandler<>(type),args);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.closeResourses(conn);
        }
        return null;
    }


    /**
     * 执行返回一行一列的SQL 语句
     * @param sql
     * @param args
     * @return
     */
    public  Object queryForSingleValue(String sql,Object... args){
        Connection conn =JdbcUtil.getConnections();
        try {
           return queryRunner.query(conn,sql,new ScalarHandler(),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.closeResourses(conn);
        }
      return null;
    }




}
