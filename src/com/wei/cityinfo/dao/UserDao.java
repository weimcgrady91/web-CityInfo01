package com.wei.cityinfo.dao;

import com.wei.cityinfo.db.DBManager;
import com.wei.cityinfo.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDao implements IBaseDao<User> {
    private DBManager dbManager = new DBManager();
    public boolean find(User user) {
        String sql = "select * from tb_user where user_name=? and user_password=?";
        Object[] params = new Object[]{
                user.getUsername(),user.getPassword()
        };
        dbManager.doPStmt(sql,params);
        ResultSet rs = null;
        try {
            rs = dbManager.getRs();
            if(rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                dbManager.close(rs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean add(User user) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }

    @Override
    public User find(int id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }
}
