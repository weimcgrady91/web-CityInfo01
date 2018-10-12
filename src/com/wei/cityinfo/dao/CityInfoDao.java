package com.wei.cityinfo.dao;

import com.wei.cityinfo.db.DBManager;
import com.wei.cityinfo.model.Info;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CityInfoDao implements IBaseDao<Info> {
    private DBManager dbManager = new DBManager();

    public CityInfoDao() {
    }


    public List<Info> findInfo(String payfor,String state,int typeSign){
        List<Info> infoList = new ArrayList<>();
        String sql = "select * from tb_info where info_payfor=? and info_state=? and info_type=?";
        Object[] params = new Object[]{
                payfor,state,typeSign
        };
        System.out.println(sql);
        dbManager.doPStmt(sql, params);
        ResultSet rs = null;
        try {
            rs = dbManager.getRs();
            while (rs.next()) {
                infoList.add(createFromRs(rs));
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
        return infoList;
    }

    public List<Info> findInfo(String condition, String key, String state,boolean accurate) {
        List<Info> infoList = new ArrayList<>();
        String sql = "select * from tb_info where info_state=? and "+condition+" like ";
        if (accurate) {
            sql += "'"+key+"'";
        } else {
            sql += "'%"+key+"%'";
        }
        Object[] params = new Object[]{
          state
        };
        dbManager.doPStmt(sql, params);
        ResultSet rs = null;
        try {
            rs = dbManager.getRs();
            while (rs.next()) {
                infoList.add(createFromRs(rs));
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
        return infoList;

    }

    private Info createFromRs(ResultSet rs) throws SQLException{
        Info info = new Info();
        info.setId(rs.getInt("id"));
        info.setType(rs.getInt("info_type"));
        info.setTitle(rs.getString("info_title"));
        info.setContent(rs.getString("info_content"));
        info.setLinkman(rs.getString("info_linkman"));
        info.setPhone(rs.getString("info_phone"));
        info.setEmail(rs.getString("info_email"));
        info.setDate(new Date(rs.getTimestamp("info_date").getTime()));
        info.setState(rs.getString("info_state"));
        info.setPayfor(rs.getString("info_payfor"));
        return info;
    }

    public List<Info> findInfoByType(int typeSign, String state ,String charge, int start, int end) {
        return findInfoByType(typeSign, state,charge, "info_date", start, end);
    }

    public List<Info> findInfoByType(int typeSign,String state, String charge, String order, int start, int end) {
        List<Info> infoList = new ArrayList<>();
        String sql = "select * from tb_info where info_type=? and info_state=? and info_payfor=? order by " + order + " desc limit ?,?";
        Object[] params = new Object[]{
                typeSign,state, charge, start, end
        };
        dbManager.doPStmt(sql, params);
        ResultSet rs = null;
        try {
            rs = dbManager.getRs();
            while (rs.next()) {
                infoList.add(createFromRs(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("按类型查找错误!");
        } finally {
            try {
                dbManager.close(rs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return infoList;
    }

    @Override
    public boolean add(Info info) {
        String sql = "insert into tb_info values(null,?,?,?,?,?,?,?,?,?)";
        Object[] params = new Object[]{
                info.getType(),
                info.getTitle(),
                info.getContent(),
                info.getLinkman(),
                info.getPhone(),
                info.getEmail(),
                new Timestamp(info.getDate().getTime()),
                info.getState(),
                info.getPayfor()
        };
        dbManager.doPStmt(sql, params);
        try {
            int count = dbManager.getCount();
            if (count > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("添加信息错误!");
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
    public Info find(int id) {
        Info info = null;
        String sql = "select * from tb_info where id=?";
        Object[] params = new Object[]{
                id,
        };
        dbManager.doPStmt(sql, params);
        ResultSet rs = null;
        try {
            rs = dbManager.getRs();
            if (rs.next()) {
                info = new Info();
                info.setId(rs.getInt("id"));
                info.setType(rs.getInt("info_type"));
                info.setTitle(rs.getString("info_title"));
                info.setContent(rs.getString("info_content"));
                info.setLinkman(rs.getString("info_linkman"));
                info.setPhone(rs.getString("info_phone"));
                info.setEmail(rs.getString("info_email"));
                info.setDate(new Date(rs.getTimestamp("info_date").getTime()));
                info.setState(rs.getString("info_state"));
                info.setPayfor(rs.getString("info_payfor"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("按id查找信息错误!");
        } finally {
            try {
                dbManager.close(rs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return info;
    }

    @Override
    public boolean delete(Info info) {
        String sql = "delete from tb_info where id=?";
        Object[] params = new Object[]{
                info.getId(),
        };
        dbManager.doPStmt(sql, params);
        try {
            int count = dbManager.getCount();
            if (count > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("删除信息错误!");
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
    public boolean update(Info info) {
        String sql = "update tb_info set info_type=?,info_title=?,info_content=?," +
                "info_linkman=?," +
                " info_phone=?,info_email=?,info_date=?,info_state=?,info_payfor=? where id=?";
        Object[] params = new Object[]{
                info.getType(),
                info.getTitle(),
                info.getContent(),
                info.getLinkman(),
                info.getPhone(),
                info.getEmail(),
                new Timestamp(info.getDate().getTime()),
                info.getState(),
                info.getPayfor(),
                info.getId()
        };
        dbManager.doPStmt(sql, params);
        try {
            int count = dbManager.getCount();
            if (count > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("更新信息错误!");
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
    public List<Info> findAll() {
//        String sql = "select * from tb_info";
//        return query(sql, null);
        return null;
    }

    public int findCountByType(int sign) {
        int count = 0;
        String sql = "select count(*) as count from tb_info where info_type=? ";
        Object[] params = new Object[]{
                sign
        };
        dbManager.doPStmt(sql,params);
        ResultSet rs = null;
        try {
            rs = dbManager.getRs();
            if(rs.next()) {
                count = rs.getInt("count");
            }
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                dbManager.close(rs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return count;
    }

    public int findCountByTypeAndState(int sign,String state) {
        int count = 0;
        String sql = "select count(*) as count from tb_info where info_type=? and info_state=?";
        Object[] params = new Object[]{
                sign,state
        };
        dbManager.doPStmt(sql,params);
        ResultSet rs = null;
        try {
            rs = dbManager.getRs();
            if(rs.next()) {
                count = rs.getInt("count");
            }
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                dbManager.close(rs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return count;
    }

    public int findCountByTypeAndCharge(int sign,String charge) {
        int count = 0;
        String sql = "select count(*) as count from tb_info where info_type=? and info_charge=?";
        Object[] params = new Object[]{
                sign,charge
        };
        dbManager.doPStmt(sql,params);
        ResultSet rs = null;
        try {
            rs = dbManager.getRs();
            if(rs.next()) {
                count = rs.getInt("count");
            }
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                dbManager.close(rs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return count;
    }

    public int findCount(int sign,String state,String charge) {
        int count = 0;
        String sql = "select count(*) as count from tb_info where info_type=? and info_state=? and info_payfor=?";
        Object[] params = new Object[]{
          sign,state,charge
        };
        dbManager.doPStmt(sql,params);
        ResultSet rs = null;
        try {
            rs = dbManager.getRs();
            if(rs.next()) {
                count = rs.getInt("count");
            }
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                dbManager.close(rs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return count;
    }

    public int findSearchCount(String key, String condition,String state, boolean accurate) {
        int count = 0;
        String sql = "select count(*) as count from tb_info where info_state=? and "+condition+" like ";
        if (accurate) {
            sql += "'"+key+"'";
        } else {
            sql += "'%"+key+"%'";
        }
        Object[] params = new Object[]{
                state,
        };
        dbManager.doPStmt(sql,params);
        ResultSet rs = null;
        try {
            rs = dbManager.getRs();
            if(rs.next()) {
                count =rs.getInt("count");
            }
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                dbManager.close(rs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return count;
    }
}
