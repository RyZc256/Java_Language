package com.servlet;

import com.entity.User;
import com.dao.Login;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        HttpServletRequest req=(HttpServletRequest) request;
        HttpServletResponse res=(HttpServletResponse) response;

        //设置编码格式
        req.setCharacterEncoding("utf-8");
        res.setContentType("text/html; charset=utf-8");

        //获取请求信息
        String username=req.getParameter("username");
        String password=req.getParameter("password");

        //获取session对象
        HttpSession hs = req.getSession();

        Login login=new Login();
        String result=login.login(username,password);
        if(result==null) {//登录成功
            User user=new User();
            user.init(username);
            hs.setAttribute("user", user);
            res.sendRedirect("/web/main.jsp");

        }else{//登录失败
            hs.setAttribute("error", result);
            res.sendRedirect("/web/login.jsp");
        }

    }
}
