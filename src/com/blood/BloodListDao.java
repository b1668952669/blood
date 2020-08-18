package com.blood;


import java.sql.Connection;
 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
 
 
/**
 * 献血Dao
 * Dao层操作数据
 * @author
 *
 */
public class BloodListDao {
 
    /**
     * 添加
     * @param bloodlist
     * @return
     */
    public boolean add(BloodList bloodlist) {
        String sql = "insert into bloodlist(name, type, volume, date) values('" + bloodlist.getName() + "','" + bloodlist.getType() + "','" + bloodlist.getVolume() + "','" + bloodlist.getDate() + "')";
        Connection conn = DBUtil.getConn();
        Statement state = null;
        boolean f = false;
        int a = 0;
         
        try {
            state = conn.createStatement();
            state.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(state, conn);
        }
         
        if (a > 0) {
            f = true;
        }
        return f;
    }
 
    /**
     * 删除
     *
     * @param id
     * @return
     */
    public boolean delete (int id) {
        boolean f = false;
        String sql = "delete from bloodlist where id='" + id + "'";
        Connection conn = DBUtil.getConn();
        Statement state = null;
        int a = 0;
         
        try {
            state = conn.createStatement();
            a = state.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(state, conn);
        }
         
        if (a > 0) {
            f = true;
        }
        return f;
    }
 
    /**
     * 修改
     * @param name
     * @param pass
     */
    public boolean update(BloodList bloodlist) {
        String sql = "update bloodlist set name='" + bloodlist.getName() + "', type='" + bloodlist.getType() + "', volume='" + bloodlist.getVolume() + "', date='" + bloodlist.getDate()
            + "' where id='" + bloodlist.getId() + "'";
        Connection conn = DBUtil.getConn();
        Statement state = null;
        boolean f = false;
        int a = 0;
 
        try {
            state = conn.createStatement();
            a = state.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(state, conn);
        }
         
        if (a > 0) {
            f = true;
        }
        return f;
    }
     
    /**
     * 验证献血人是否唯一
     * true --- 不唯一
     * @param name
     * @return
     */
    public boolean name(String name) {
        boolean flag = false;
        String sql = "select name from bloodlist where name = '" + name + "'";
        Connection conn = DBUtil.getConn();
        Statement state = null;
        ResultSet rs = null;
         
        try {
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            while (rs.next()) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, state, conn);
        }
        return flag;
    }
     
    /**
     * 通过ID得到类
     * @param id
     * @return
     */
    public BloodList getBloodListById(int id) {
        String sql = "select * from bloodlist where id ='" + id + "'";
        Connection conn = DBUtil.getConn();
        Statement state = null;
        ResultSet rs = null;
        BloodList bloodlist = null;
         
        try {
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString("name");
                String type = rs.getString("type");
                String volume = rs.getString("volume");
                String date = rs.getString("date");
                bloodlist = new BloodList(id, name, type, volume, date);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, state, conn);
        }
         
        return bloodlist;
    }
     
    /**
     * 通过name得到BloodList
     * @param name
     * @return
     */
    public BloodList getBloodListByName(String name) {
        String sql = "select * from bloodlist where name ='" + name + "'";
        Connection conn = DBUtil.getConn();
        Statement state = null;
        ResultSet rs = null;
        BloodList bloodlist = null;
         
        try {
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String type = rs.getString("type");
                String volume = rs.getString("volume");
                String date = rs.getString("date");
                bloodlist = new BloodList(id, name, type, volume, date);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, state, conn);
        }
         
        return bloodlist;
    }

     
    /**
     * 全部数据
     * @param name
     * @param type
     * volume
     * @param date
     * @return
     */
    public List<BloodList> list() {
        String sql = "select * from bloodlist";
        List<BloodList> list = new ArrayList<>();
        Connection conn = DBUtil.getConn();
        Statement state = null;
        ResultSet rs = null;
 
        try {
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            BloodList bean = null;
            while (rs.next()) {
                int id = rs.getInt("id");
                String name2 = rs.getString("name");
                String type2 = rs.getString("type");
                String volume2 = rs.getString("volume");
                String date2 = rs.getString("date");
                bean = new BloodList(id, name2, type2, volume2, date2);
                list.add(bean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, state, conn);
        }
         
        return list;
    }
 
}