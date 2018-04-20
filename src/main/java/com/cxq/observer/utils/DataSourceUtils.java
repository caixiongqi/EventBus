package com.cxq.observer.utils;

import javax.sql.DataSource;
import java.sql.*;

public class DataSourceUtils {

    public synchronized static void getDataSource() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // 加载数据库驱动
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // 通过驱动管理类获取数据库链接
            connection = DriverManager
                    .getConnection(
                            "jdbc:oracle:thin:@192.168.90.250:1521:workflow",
                            "xxx", "password");
            // 定义sql语句 ?表示占位符
            String sql = "insert into htgl_zjk(id, HT_NAME) values(?, ?)";
            // 获取预处理statement
            preparedStatement = connection.prepareStatement(sql);
            // 设置参数，第一个参数为sql语句中参数的序号（从1开始），第二个参数为设置的参数值
            preparedStatement.setString(1, "111");
            preparedStatement.setString(2, "局级");
            // 向数据库发出sql执行查询，查询出结果集
            int flag = preparedStatement.executeUpdate();
            // 遍历查询结果集
            /*while (resultSet.next()) {
                System.out.println(resultSet.getString("id") + "  "
                        + resultSet.getString("ht_name"));
            }*/
            System.out.println(flag);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}
