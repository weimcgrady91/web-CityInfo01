package com.wei.cityinfo.db;


import java.sql.*;

public class DBManager {
    public static String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static String URL = "jdbc:mysql://localhost:3306/db_cityinfo?useSSL=false&serverTimezone=GMT%2B8&allowPublicKeyRetrieval=true";
    public static String USER_NAME = "weimcgrady91";
    public static String PASSWORD = "880516";
    private Connection conn;
    private PreparedStatement pStmt;

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        try {
            conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败!");
        }
        return conn;
    }

    public void doPStmt(String sql, Object[] params) {
        if (sql != null && !sql.equals("")) {
            if (params == null) {
                params = new Object[0];
            }
            getConnection();
            if (conn != null) {
                try {
                    pStmt = conn.prepareStatement(sql);
                    for (int i = 0; i < params.length; i++) {
                        pStmt.setObject(i + 1, params[i]);
                    }
                    pStmt.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("doPStmt()方法出错！");
                }
            }
        }
    }

    public ResultSet getRs() throws SQLException {
        return pStmt.getResultSet();
    }

    public int getCount() throws SQLException {
        return pStmt.getUpdateCount();
    }


    public void close() throws Exception {
        if (conn != null) {
            conn.close();
        }
        if (pStmt != null) {
            pStmt.close();
        }
    }

    public void close(ResultSet rs) throws Exception {
        if (rs != null) {
            rs.close();
        }
        this.close();

    }
}
