package com.Servlet;

import com.Dao.GoodDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GoodDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        PrintWriter out = resp.getWriter();
        GoodDao goodDao = new GoodDao();
        int rows = goodDao.delete(id);
        if ( id != 0){
            if (rows > 0){
                out.println("<script type='text/javascript'>location.href='goodQueryServlet';</script>");
            }
        }
    }
}
