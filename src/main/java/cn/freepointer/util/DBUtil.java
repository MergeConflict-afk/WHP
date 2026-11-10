package cn.freepointer.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * JDBC工具类
 */
public class DBUtil {
    // 数据库连接信息，改成你自己的MySQL账号密码
    private static final String URL = "jdbc:mysql://localhost:3306/web_homework?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai&useSSL=false";
    private static final String USER = "root";
    private static final String PWD = "1234";
//用的是web_homework数据库用来存放用户数据
    // 静态代码块：项目启动时加载一次驱动
    static {
        try {
            // MySQL8.0用这个驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            // MySQL5.7换成：Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PWD);
    }

    /**
     * 关闭资源，重载三种参数组合
     */
    public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
        try { if(rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
        try { if(pstmt != null) pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
        try { if(conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
    }

    public static void close(PreparedStatement pstmt, Connection conn) {
        close(null, pstmt, conn);
    }
}
