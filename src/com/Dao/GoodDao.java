package com.Dao;

import com.Entity.GoodsInfo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GoodDao {
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
    public void closeAll(Connection conn, PreparedStatement pra, ResultSet rs){
        //关闭资源
        try{
            if (conn != null)conn.close();
            if (pra != null )pra.close();
            if (rs != null ) rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<GoodsInfo> findByGoods(GoodsInfo goodsInfo){//展示商品首页
        Connection conn = null;
        PreparedStatement pra = null;
        ResultSet rs = null;
        List<GoodsInfo> list = new ArrayList<>();
        try{
            //1、获取连接对象
            conn = this.getConnection();
            //2、获得sql语句集并执行
            String sql = "select * from goodsinfo";
            pra = conn.prepareStatement(sql);
            rs = pra.executeQuery();
            while (rs.next() ){
                GoodsInfo goodsInfo1 = new GoodsInfo();
                goodsInfo1.setId(rs.getInt("id"));
                goodsInfo1.setGoodsInfoName(rs.getString("goodsInfo_name"));
                goodsInfo1.setGoodInfoPic(rs.getString("goodsInfo_pic"));
                goodsInfo1.setGoodsInfoPrice(rs.getString("goodsInfo_price"));
                goodsInfo1.setGoodsInfoDescription(rs.getString("goodsInfo_description"));
                goodsInfo1.setGoodsStock(rs.getString("goods_stock"));
                goodsInfo1.setFlag(rs.getString("flag"));
                list.add(goodsInfo1);
            }
            return list;
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            this.closeAll(conn,pra,rs);
        }
        return list;
    }


    public int add(GoodsInfo goodsInfo){//商品添加
        Connection conn = null;
        PreparedStatement pra = null;
        ResultSet rs = null;
        try{
            //1、获得连接对象
            conn = this.getConnection();
            //获得sql语句集并执行
//            String sql = "insert into goodsinfo(goodsInfoName,goodInfoPic,goodsInfoPrice,goodsInfoDescription,goodsStock,flag) values(?,?,?,?,?,?)";
            String sql = "insert into goodsinfo(goodsInfo_name,goodsInfo_pic,goodsInfo_price,goodsInfo_description,goods_stock,flag) values(?,?,?,?,?,?)";
//            `goodsInfo_name``goodsInfo_pic``goodsInfo_price``goodsInfo_description``goods_stock``flag`
            //获得预编译语句集
            pra = conn.prepareStatement(sql);
            //设置占位符
            pra.setString(1,goodsInfo.getGoodsInfoName());
            pra.setString(2,goodsInfo.getGoodInfoPic());
            pra.setString(3,goodsInfo.getGoodsInfoPrice());
            pra.setString(4,goodsInfo.getGoodsInfoDescription());
            pra.setString(5,goodsInfo.getGoodsStock());
            pra.setString(6,goodsInfo.getFlag());
            int rows=pra.executeUpdate();
            if (rows>0){
               return rows;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeAll(conn,pra,rs);
        }
        return 0;
    }
    public int delete(int id){//商品删除
        Connection conn = null;
        PreparedStatement pra = null;
        ResultSet rs = null;
        try{
            conn = this.getConnection();
            String sql = "DELETE FROM goodsinfo WHERE id=?;";
            pra = conn.prepareStatement(sql);
            pra.setInt(1,id);
            int rows = pra.executeUpdate();
            if (rows >0){
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
