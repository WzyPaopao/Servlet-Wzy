package com.wzy.wzy_shop.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class BaseDao {
    protected static DataSource DATASOURCE = null;

    static {
        Properties properties = new Properties();
        try {
            properties.load(BaseDao.class.getClassLoader().getResourceAsStream("hikari.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        HikariConfig hikariConfig = new HikariConfig(properties);
        DATASOURCE = new HikariDataSource(hikariConfig);
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            connection = BaseDao.DATASOURCE.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    protected void closeAll(Connection connection, Statement statement, ResultSet resultSet) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

         if (statement != null) {
             try {
                 statement.close();
             } catch (SQLException throwables) {
                 throwables.printStackTrace();
             }
         }

         if (resultSet != null) {
             try {
                 resultSet.close();
             } catch (SQLException throwables) {
                 throwables.printStackTrace();
             }
         }

    }
}
