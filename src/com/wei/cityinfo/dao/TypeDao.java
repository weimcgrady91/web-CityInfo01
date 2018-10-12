package com.wei.cityinfo.dao;

import com.wei.cityinfo.db.DBManager;
import com.wei.cityinfo.model.Type;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TypeDao implements IBaseDao<Type> {
    private DBManager dbManager = new DBManager();

    @Override
    public boolean add(Type type) {
        try {
            String sql = "insert into tb_type values(null,?,?)";
            Object[] params = new Object[]{
                    type.getTypeName(), type.getTypeIntro()
            };
            dbManager.doPStmt(sql, params);
            int count = dbManager.getCount();
            if (count > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("添加类型时出现错误!");
        } finally {
            try {
                dbManager.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Type find(int id) {
        return null;
    }

    @Override
    public boolean delete(Type type) {
        return false;
    }

    @Override
    public boolean update(Type type) {
        return false;
    }

    @Override
    public List<Type> findAll() {
        List<Type> types = new ArrayList<>();
        String sql = "select * from tb_type";
        dbManager.doPStmt(sql, null);
        ResultSet rs = null;
        try {
            rs = dbManager.getRs();
            while (rs.next()) {
                Type type = new Type();
                type.setTypeSign(rs.getInt("type_sign"));
                type.setTypeName(rs.getString("type_name"));
                type.setTypeIntro(rs.getString("type_intro"));
                types.add(type);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("查询所有类型时出错!");
        } finally {
            try {
                dbManager.close(rs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return types;
    }
}
