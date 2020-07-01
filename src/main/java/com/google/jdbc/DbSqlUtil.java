package com.google.jdbc;


import java.sql.*;
import java.util.*;


public class DbSqlUtil {


    public static void main(String[] args) {
        DbSqlUtil dbSqlUtil = new DbSqlUtil();
        //dbSqlUtil.produceSql();
        dbSqlUtil.modifyData();
        dbSqlUtil.close();
    }

    private void modifyData() {
        try {
            con = this.getConnection();
            String querySql = "SELECT * FROM T_MSG_ZNX";
            Statement state = con.createStatement();
            ResultSet rs = state.executeQuery(querySql);
            Set<Long> set = new HashSet<>();
            while (rs.next()) {    //next（）获取里面的内容
                Long id = rs.getLong("ID");
                set.add(id);
            }
            for (Long id : set) {
                String sql = "UPDATE T_MSG_ZNX SET BID ='" + BidUtil.getBid() + "'" + " WHERE ID=" + id;
                state.executeUpdate(sql);
                System.out.println(id);
            }
            System.out.println();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void produceSql() {
        Set<String> exceptTables = new HashSet<>();
        exceptTables.add("t_area");
        exceptTables.add("t_cfg_dictionary");
        exceptTables.add("t_cfg_linkageconfig");
        exceptTables.add("t_data_cnaps");
        exceptTables.add("t_dept_company");
        exceptTables.add("t_dept_department");
        exceptTables.add("t_msg_template");
        exceptTables.add("t_rbac_btn2role");
        exceptTables.add("t_rbac_btnregister");
        exceptTables.add("t_rbac_resource");
        exceptTables.add("t_rbac_resource2role");
        exceptTables.add("t_rbac_role");
        exceptTables.add("t_rbac_userpermission");
        exceptTables.add("t_user_user");
        exceptTables.add("t_user_user2role");
        try {
            con = this.getConnection();
            String sql = "select CONCAT('TRUNCATE TABLE ',table_name,';') from information_schema.tables where TABLE_SCHEMA = 'scm_zhonghujin_v2_dev';";
            psmt = con.prepareStatement(sql);
            ResultSet rs = psmt.executeQuery(sql);
            int i = 0;
            int j = 0;
            while (rs.next()) {    //next（）获取里面的内容
                String temp = rs.getString(1);
                if (!exceptTables.contains(temp.replace("TRUNCATE TABLE ", "")
                        .replace(";", ""))) {
                    System.out.println(rs.getString(1));
                    ++j;
                }
                ++i;
            }
            System.out.println(i + "  " + j);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private final String oracleDriver = "com.mysql.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/scm_zhonghujin_v2_dev";
    private final String user = "";
    private final String password = "";


    private Connection con = null;
    private PreparedStatement psmt = null;
    private ResultSet rs = null;


    public DbSqlUtil() {
    }


    /**
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     * @Title: getConnection
     * @Description: 获取数据库链接
     */
    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(this.oracleDriver);
        return DriverManager.getConnection(url, user, password);
    }


    /**
     * @Title: close
     * @Description: 关闭连接
     */
    private void close() {
        try {
            if (rs != null) rs.close();
            if (psmt != null) psmt.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}