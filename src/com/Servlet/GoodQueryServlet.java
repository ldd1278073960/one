package com.Servlet;

import com.Dao.GoodDao;
import com.Entity.GoodsInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

//代码负责让商品信息在页面上显示出来

public class GoodQueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        GoodDao goodDao = new GoodDao();//实例化GoodDao对象

        List<GoodsInfo> list = goodDao.findByGoods(null);//调用goodDao中的findByGoods方法

        req.setAttribute("list",list);//设置键值
        req.getRequestDispatcher("good_list.jsp").forward(req,resp);

    }
}