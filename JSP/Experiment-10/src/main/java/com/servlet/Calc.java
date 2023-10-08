package com.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "Calc", value = "/Calc")
public class Calc extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String function = request.getParameter("op");
        int a = Integer.parseInt(request.getParameter("a"));
        System.out.println(a);
        int b = Integer.parseInt(request.getParameter("b"));
        System.out.println(b);
        int sum = 0;
        if(function.equals("sum")){
            sum=a+b;
            request.setAttribute("result", sum);
        }else if(function.equals("sub")){
            sum=a-b;
            request.setAttribute("result", sum);
        }else if(function.equals("mul")){
            sum=a*b;
            request.setAttribute("result", sum);
        }else if(function.equals("div")){
            sum=a/b;
            request.setAttribute("result", sum);
        }
        String path="result.jsp";
        request.getRequestDispatcher(path).forward(request, response);
    }
}
