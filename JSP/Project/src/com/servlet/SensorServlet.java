package com.servlet;

import com.entity.Data;
import com.entity.Sensor;
import com.entity.Project;
import com.dao.DataDao;
import com.dao.SensorDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class SensorServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //设置编码格式
        req.setCharacterEncoding("utf-8");
        res.setContentType("text/html; charset=utf-8");

        String methodName =req.getParameter("method");

        Class<? extends SensorServlet> cls =this.getClass();
        Method method= null;
        try {
            method = cls.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this,req,res);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void getAllSensorInfo(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String P_ID = req.getParameter("P_ID");

        if(P_ID!=null){
            Project project=new Project(P_ID);

            SensorDao em=new SensorDao(project);
            ArrayList<Sensor> list=em.getAllSensor();

            HttpSession hs=req.getSession();
            hs.setAttribute("project",project);
            hs.setAttribute("sensorList",list);
            res.sendRedirect("/web/SensorPanel.jsp");
        }else {
            res.sendRedirect("/web/error.jsp");
        }
    }

    public void delSensor(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String S_ID=req.getParameter("S_ID");

        Sensor sensor=new Sensor(Integer.parseInt(S_ID));
        Project project =new Project(String.valueOf(sensor.getP_ID()));
        SensorDao sm=new SensorDao(project);
        req.setAttribute("P_ID",sensor.getP_ID());
        sm.delSensor(project,sensor);

        res.sendRedirect("/web/loadSensor.jsp");
    }

    public void editSensor(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String S_ID = req.getParameter("S_ID");

        String S_Name =req.getParameter("S_Name");
        String S_Tag=req.getParameter("S_Tag");
        String S_Serial=req.getParameter("S_Serial");

        Sensor sensor=new Sensor(Integer.parseInt(S_ID));
        Project project =new Project(String.valueOf(sensor.getP_ID()));
        SensorDao sm=new SensorDao(project);

        if(!S_Name.equals(""))sensor.setS_Name(S_Name);
        if(!S_Tag.equals(""))sensor.setS_Tag(S_Tag);
        if(!S_Serial.equals(""))sensor.setS_Serial(S_Serial);

        sm.editSensor(project,sensor);
        res.sendRedirect("/web/loadSensor.jsp");
    }

    public void addSensor(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String P_ID = req.getParameter("P_ID");
        String S_Name = req.getParameter("S_Name");
        String S_Tag = req.getParameter("S_Tag");
        String S_Serial = req.getParameter("S_Serial");
        String M_ID = req.getParameter("M_ID");

        System.out.println("addSensor"+1);

        Sensor sensor=new Sensor(S_Name,S_Tag,S_Serial,Integer.parseInt(M_ID),Integer.parseInt(P_ID));
        Project project=new Project(P_ID);
        SensorDao sm=new SensorDao(project);

        sm.addSensor(project,sensor);
        res.sendRedirect("/web/loadSensor.jsp");
    }

    public void getData(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String S_ID = req.getParameter("S_ID");
        Sensor sensor=new Sensor(Integer.parseInt(S_ID));
        DataDao dm=new DataDao();
        //获取sensor的数据
        ArrayList<Data> list=dm.getAllData(sensor);
        //获取session
        HttpSession session= req.getSession();
        session.setAttribute("DataList",list);
        session.setAttribute("sensor",sensor);
        //重新指向data.jsp
        res.sendRedirect("/web/data.jsp");
    }
}

