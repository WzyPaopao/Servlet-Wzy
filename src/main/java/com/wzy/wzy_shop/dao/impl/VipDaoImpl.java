package com.wzy.wzy_shop.dao.impl;

import com.wzy.wzy_shop.dao.BaseDao;
import com.wzy.wzy_shop.dao.VipDao;
import com.wzy.wzy_shop.entity.Vip;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VipDaoImpl extends BaseDao implements VipDao {
    @Override
    public int save(Vip vip) {
        String sql = "insert into vip(username, password, gender, salt) values (?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement statement = null;
        int res = -1;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, vip.getUsername());
            statement.setString(2, vip.getPassword());
            statement.setString(3, vip.getGender());
            statement.setString(4, vip.getSalt());
            res = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(connection, statement, null);
        }

        return res;
    }

    @Override
    public List<Vip> findUserByUsername(String username) {
        String sql = "select * from vip where username=?";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Vip> vips = new ArrayList<>();

        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Vip vip = new Vip();
                vip.setUsername(resultSet.getString("username"));
                vip.setPassword(resultSet.getString("password"));
                vip.setSalt(resultSet.getString("salt"));
                vip.setGender(resultSet.getString("gender"));
                vip.setProfile(resultSet.getString("profile"));
                vip.setName(resultSet.getString("name"));
                vips.add(vip);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(connection, statement, resultSet);
        }

        return vips;
    }
}
