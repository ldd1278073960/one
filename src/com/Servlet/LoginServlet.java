package com.Servlet;

import com.Dao.UserDao;
import com.Entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if ( username.equals("") || password.equals("")) {
            HttpSession session = req.getSession();
            req.setAttribute("msg","用户名与密码不能为空");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }else {
            UserDao userDao = new UserDao();
            User byUser = userDao.findByUser(username, password);
            if (byUser != null) {
                HttpSession session = req.getSession();
                User user = new User(username,password);
                session.setAttribute("User",user);
                req.setAttribute("msg", "登陆成功");
                req.getRequestDispatcher("/goodQueryServlet").forward(req, resp);
            } else {
                req.setAttribute("smg", "用户名或密码输出错误");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        }
    }
}