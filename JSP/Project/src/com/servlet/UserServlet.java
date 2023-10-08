package com.servlet;

import com.entity.User;
import com.dao.UserDao;
import com.util.EmailSend;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.mail.Session;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UserServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //设置编码格式
        req.setCharacterEncoding("utf-8");
        res.setContentType("text/html; charset=utf-8");

        String methodName =req.getParameter("method");

        Class<? extends UserServlet> cls =this.getClass();
        Method method= null;
        try {
            method = cls.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this,req,res);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void editUserInfo(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
        String U_Name=req.getParameter("U_Name");
        String U_Email=req.getParameter("U_Email");
        String U_Telphone=req.getParameter("U_Telphone");
        String U_IdCard=req.getParameter("U_IdCard");
        User user=new User(U_Name);

        if(U_Email!=null)user.setU_Email(U_Email);
        if(U_IdCard!=null)user.setU_Idcard(U_IdCard);
        if(U_Telphone!=null)user.setU_Telphone(U_Telphone);
        UserDao um=new UserDao(user);
        if(um.editUserInfo()){
            HttpSession hs = req.getSession();

            hs.setAttribute("user", user);
            res.sendRedirect("/web/account.jsp");
        }else {
            res.sendRedirect("/web/error.jsp");
        }
    }

    public void editPassword(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
        HttpSession hs = req.getSession();
        User user = (User) hs.getAttribute("RTP_user");
        String U_Passwrd = req.getParameter("U_Password");
        user.setU_Password(U_Passwrd);
        UserDao userDao = new UserDao(user);

        hs.setAttribute("Verify_Result",null);
        if(userDao.editPassword())
            res.sendRedirect("/web/login.jsp");

    }

    public void Verify(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
        String code=req.getParameter("code");
        HttpSession hs = req.getSession();
        if(code.equals(hs.getAttribute("Vcode"))){
            hs.setAttribute("Verify_Result",true);
            res.sendRedirect("/web/editpwd.jsp");
        }else{
            res.sendRedirect("/web/emailVerifyCode.jsp");
        }
    }

    public void sendEmail(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
        String U_Name=req.getParameter("U_Name");
        User user = new User(U_Name);
        EmailSend emailSend = new EmailSend(user.getU_Email());
        String code = emailSend.retrieve(user);
        HttpSession hs = req.getSession();
        hs.setAttribute("Vcode",code);
        hs.setAttribute("RTP_user",user);
        res.sendRedirect("/web/emailVerifyCode.jsp");
    }




}
