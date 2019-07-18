package com.Servlet;

import com.Dao.UserDao;
import com.Entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class RegisteredServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String Id =req.getParameter("Id");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String password1 = req.getParameter("password1");
        String sex = req.getParameter("sex");
        String[] hobbys = req.getParameterValues("hobbys");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String addrs = req.getParameter("addrs");
        String flag = req.getParameter("flag");
        StringBuffer sf = new StringBuffer();
        int size = email.indexOf('@');//判断email字符串中有没有@
        int size1 = email.indexOf('.');//判断email字符串中有没有 .
        PrintWriter out = resp.getWriter();
        if (username.equals("") || password.equals("") || Id.equals("") || sex.equals("") || phone.equals("")
                || email.equals("") || addrs.equals("") || password1.equals("")) {
                out.println("<script type=\"text/javascript\">alert(\"注册失败，请检查是否全部填写\");history.go(-1);</script>");
        } else if (password.length()<6) {
            out.println("<script type=\"text/javascript\">alert(\"密码必须大于6位\");history.back();</script>");
        }else if( !password.equals(password1)){
            out.println("<script type=\"text/javascript\">alert(\"请检查两次密码是否一致\");history.back();</script>");
        } else if(size == -1 || size1 == -1 ||email.startsWith("@") || email.endsWith("@")
                ||email.startsWith(".") || email.endsWith(".") || size+1 ==size1 || size-1 == size1){
            out.println("<script type=\"text/javascript\">alert(\"邮箱格式不正确\");history.back();</script>");
        }else {
            for(String i : hobbys){
                sf.append(i);
            }
            req.setAttribute("msg", "注册成功");
            UserDao userDao =new UserDao();
            userDao.findByRegistered(Integer.parseInt(Id),username,password,sex,sf.toString(),phone,email,addrs,flag);
            req.getRequestDispatcher("login.jsp").forward(req, resp);
            }

    }
}