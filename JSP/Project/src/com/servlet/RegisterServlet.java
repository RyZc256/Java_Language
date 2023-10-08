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

public class RegisterServlet extends HttpServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        HttpServletRequest req=(HttpServletRequest) request;
        HttpServletResponse res=(HttpServletResponse) response;

        //设置编码格式
        req.setCharacterEncoding("utf-8");
        res.setContentType("text/html; charset=utf-8");

        //获取请求信息
        String U_Account=req.getParameter("U_Account");
        String U_Password=req.getParameter("U_Password");
        String U_Email=req.getParameter("U_Email");
        String U_Idcard=req.getParameter("U_Idcard");
        String U_Telphone=req.getParameter("U_Telphone");

        //注册并返回结果
        User user=new User(U_Account,U_Password,U_Email,U_Idcard,U_Telphone);
        Login login=new Login();
        String result=login.register(user);

        //获取session对象
        HttpSession hs = req.getSession();

        if(result==null){//注册成功
            res.sendRedirect("/web/login.jsp"); //转到登录界面
        }else{//注册失败
            hs.setAttribute("error",result);    //返回失败信息
            res.sendRedirect("/web/register.jsp");  //转到注册页面
        }
    }
}
