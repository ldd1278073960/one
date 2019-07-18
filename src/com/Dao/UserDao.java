package com.Dao;

import com.Entity.GoodsInfo;
import com.Entity.User;

import java.sql.*;

public class UserDao {
    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/phaseproject?characterEncoding=utf8&useSSL=false&serverTimezone=CST";
    private static final String username = "root";
    private static final String password = "root";
    public Connection getConnection(){
        try{
            //1、获取连接对象
            Class.forName(DRIVER_CLASS);
            return DriverManager.getConnection(url,username,password);
        }catch ( ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void closeAll(Connection conn,PreparedStatement pra,ResultSet rs){
        //关闭资源
        try{
            if (conn != null)conn.close();
            if (pra != null )pra.close();
            if (rs != null ) rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public User findByUser(String username,String password){
        Connection conn = null;
        PreparedStatement pra = null;
        ResultSet rs = null;
        try{
            //1、获得连接对象
            conn = this.getConnection();
            //获得sql语句集并执行
            String sql = "select * from user where username=? and password=?";
            //获得预编译语句集
            pra = conn.prepareStatement(sql);
            //设置占位符
            pra.setString(1,username);
            pra.setString(2,password);
            //执行sql语句
            rs = pra.executeQuery();
            if (rs.next()){
                User user = new User();
                user.setId(rs.getInt("Id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setSex(rs.getString("sex"));
                user.setHobbys(rs.getString("hobbys"));
                user.setPhone(rs.getString("phone"));
                user.setEmail(rs.getString("email"));
                user.setAddrs(rs.getString("addrs"));
                user.setFlag(rs.getString("flag"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeAll(conn,pra,rs);
        }
        return null;
    }
    public int findByRegistered(int Id,String username,String password,String sex,String hobbys,String phone,
    String email,String addrs,String flag) {
        Connection conn = null;
        PreparedStatement pra = null;
        ResultSet rs = null;
        try{
            //1、获得连接对象
            conn = this.getConnection();
            //获得sql语句集并执行
            String sql = "insert into user(username,password,sex,hobbys,phone,email,addrs) values(?,?,?,?,?,?,?)";
            //获得预编译语句集
            pra = conn.prepareStatement(sql);
            //设置占位符
            pra.setString(1,username);
            pra.setString(2,password);
            pra.setString(3,sex);
            pra.setString(4,hobbys);
            pra.setString(5,phone);
            pra.setString(6,email);
            pra.setString(7,addrs);
            //执行sql语句
            int rows = pra.executeUpdate();
            if (rows >0) {
                return rows;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeAll(conn,pra,rs);
        }
        return 0;
    }
}
