package com.bookstrore.Test;

import com.bookstrore.Utils.JdbcUtil;
import org.junit.Test;

import java.sql.Connection;

/**
 * @author nono
 * @Package com.bookstrore.Test
 * @ClassName connTest.java
 * @Description 数据库连接测试
 * @createTime 2020年08月10日 14:27:00
 */
public class connTest {
    @Test
    public void testconn(){
        Connection connection = JdbcUtil.getConnections();
        System.out.println(connection);
    }
}
