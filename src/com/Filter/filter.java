package com.Filter;

import javax.servlet.*;
import java.io.IOException;

public class filter implements Filter {
    private String encoding;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encoding = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //1、设置请求的编码
        servletRequest.setCharacterEncoding(encoding);
        //2、设置响应编码
        servletResponse.setCharacterEncoding(encoding);
        //浏览器以什么编码方式执行
        servletResponse.setContentType("text/html;charset=utf-8");
        filterChain.doFilter(servletRequest,servletResponse);
    }
    @Override
    public void destroy() {
    }
}
