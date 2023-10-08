package com.servlet;
import com.entity.Project;
import com.entity.User;
import com.dao.ProjectDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class ProjectServlet extends HttpServlet{
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        //设置编码格式
        req.setCharacterEncoding("utf-8");
        res.setContentType("text/html; charset=utf-8");
        //获取调用的方法名称
        String methodName=req.getParameter("method");
        //反射获取类
        Class<? extends ProjectServlet> cla = this.getClass();
        try {
            //获取调用的方法
            Method method= cla.getMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
            //执行改方法
            method.invoke(this,req,res);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    public void editProject(HttpServletRequest req,HttpServletResponse res) throws IOException {
        String P_ID =req.getParameter("P_ID");
        String P_Name =req.getParameter("P_Name");

        HttpSession hs=req.getSession();

        ProjectDao pm =new ProjectDao();

        Project project=new Project(P_ID);
        project.setP_Name(P_Name);

        if(!pm.editProject(project)){
            hs.setAttribute("error","修改失败，请联系客服并稍后重试");
        }

        res.sendRedirect("/web/loadProject.jsp");
    }
    public void delProject(HttpServletRequest req,HttpServletResponse res) throws IOException {

        String P_ID =req.getParameter("P_ID");

        HttpSession hs=req.getSession();

        ProjectDao pm =new ProjectDao();
        Project project=new Project(P_ID);

        if(!pm.deleteProject(project)){
            hs.setAttribute("error","添加失败，请联系客服并稍后重试");
        }

        res.sendRedirect("/web/loadProject.jsp");
    }

    public void getProjectInfo(HttpServletRequest req,HttpServletResponse res) throws IOException {

        String U_ID=req.getParameter("U_ID");
        ProjectDao pm=new ProjectDao();
        HttpSession hs= req.getSession();
        if(U_ID!=null){
            ArrayList<Project> list =pm.getAllProject(U_ID);
            hs.setAttribute("ProjectList",list);
        }
        res.sendRedirect("/web/dashboard.jsp");
    }

    public void createProject(HttpServletRequest req,HttpServletResponse res) throws IOException {

        String P_Name = req.getParameter("P_Name");
        String U_ID = req.getParameter("U_ID");
        String P_Tag = req.getParameter("P_Tag");

        HttpSession hs=req.getSession();

        if(P_Name !=null && U_ID!=null && P_Tag !=null){

            User user=new User();
            user.setU_ID(Integer.parseInt(U_ID));
            Project project=new Project(P_Name,"P9"+P_Tag,user);
            ProjectDao pm=new ProjectDao();

            if(!pm.addProject(project)){
                hs.setAttribute("error","添加失败，请联系客服并稍后重试");
            }
        } else{
            hs.setAttribute("error","添加失败，请联系客服并稍后重试");
        }
        res.sendRedirect("/web/loadProject.jsp");
    }
}
