package com.util;

import com.entity.Student;
import com.entity.Task;
import com.entity.User;
import com.mysql.cj.jdbc.result.ResultSetImpl;

import javax.swing.table.DefaultTableModel;
import java.lang.ref.PhantomReference;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class opHome implements InterfaceHome {
    private DBManger db;

    public opHome(){
        db = new DBManger();
    }

    public DefaultTableModel stuGetAttend(User user){
        String sql = "SELECT * FROM attend WHERE Student=? ORDER BY Date DESC";
        String[] title = {"日期","打卡时间","打卡状态"};
        DefaultTableModel defaultTableModel = new DefaultTableModel(title,0);
        try{
            PreparedStatement pstms = db.getConn().prepareStatement(sql);
            pstms.setInt(1,user.getAccount());

            ResultSet rs = pstms.executeQuery();
            if(rs!=null){
                while(rs.next()){
                    String[] data = {rs.getString("Date"),
                            rs.getString("Datetime"),
                            rs.getInt("Status")!=1?"未打卡":"已打卡"
                    };
                    defaultTableModel.addRow(data);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return defaultTableModel;
    }

    @Override
    public boolean stuTodayAttend() {
        String sql = "SELECT * FROM attend WHERE Date=?";
        PreparedStatement pstms;
        try{
            pstms = db.getConn().prepareStatement(sql);
            pstms.setString(1,new Datetime().now().split(" ")[0]);
            ResultSet rs = null;
            rs = pstms.executeQuery();
            // 如果找到了今日的打卡记录,直接退出方法
            if(rs.next())
                return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        ArrayList<Integer> accounts = new ArrayList<>();
        // 查找所有用户名
        try{
            String query = "SELECT Account FROM student;";
            pstms = db.getConn().prepareStatement(query);
            ResultSet rs = pstms.executeQuery();
            while(rs.next()){
                int account = rs.getInt("Account");
                accounts.add(account);
            }
//             创建今日打卡记录
            for(int i:accounts){
                String insert = "INSERT INTO attend(Student, Date) VALUES (?, ?);";
                pstms = db.getConn().prepareStatement(insert);
                pstms.setInt(1,i);
                pstms.setString(2,new Datetime().now().split(" ")[0]);
                pstms.executeUpdate();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public int stuUpDateAttend(User user) {
        int result = 0;
        String select = "SELECT * FROM attend WHERE Student=? AND Date=? AND Status=1;";
        PreparedStatement pstms;
        try{
            pstms = db.getConn().prepareStatement(select);
            pstms.setInt(1,user.getAccount());
            pstms.setString(2,new Datetime().now().split(" ")[0]);
            ResultSet rs = pstms.executeQuery();
            if(rs.next())
                return 3;
        }catch (Exception e){
            e.printStackTrace();
        }
        String sql = "UPDATE attend SET Status = 1,DateTime=? WHERE Student = ? AND Date = ?;";
        try{
            pstms = db.getConn().prepareStatement(sql);
            pstms.setString(1,new Datetime().now());
            pstms.setInt(2,user.getAccount());
            pstms.setString(3,new Datetime().now().split(" ")[0]);
            result = pstms.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        if(result != 0)
            return 1;
        else
            return 2;
    }

    @Override
    public ArrayList<Task> stuGetTask(User user) {
        ArrayList<Task> result = new ArrayList<>();
        try{
            CallableStatement cs = db.getConn().prepareCall("call getStuTask(?,?)");
            cs.setInt(1,user.getAccount());
            cs.setString(2,new Datetime().now());
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                if(rs.getInt("Status") == 0){
                    Task task = new Task(rs.getInt("ID"),
                            rs.getInt("Student"),
                            null,
                            null,
                            rs.getString("Title"),
                            rs.getString("Content"),
                            rs.getString("DispatchTime"),
                            rs.getString("Deadline"),
                            rs.getInt("Teacher"),
                            0);
                    System.out.println(task.toString());
                    result.add(task);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean stuUpDateTask(Task task) {
        int result = 0;
        String sql = "UPDATE stutask SET Status = 1,Path=?,CompletionTime=? WHERE Student = ? AND ID = ?;";
        try{
            PreparedStatement pstms = db.getConn().prepareStatement(sql);
            System.out.println(task.toString());
            pstms.setString(1,task.getPath());
            pstms.setString(2,task.getCompletionTime());
            pstms.setInt(3,task.getStudent());
            pstms.setInt(4,task.getId());
            result = pstms.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        if(result!=0)
            return true;
        else
            return false;
    }

    @Override
    public boolean teafinishTask(Task task) {
        int result = 0;
        String sql = "UPDATE teatask SET Deadline=? WHERE ID=?";
        try{
            PreparedStatement pstms = db.getConn().prepareStatement(sql);
            pstms.setString(1,task.getDeadline());
            pstms.setInt(2,task.getId());
            result = pstms.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        if(result!=0)
            return true;
        else
            return false;
    }

    @Override
    public boolean teaPublishTask(Task task,ArrayList<Student> students) {
        int result = 0;
        String sql = "INSERT INTO teatask(Title,Content,DispatchTime,Deadline,Teacher) VALUES(?,?,?,?,?);";
        try{
            PreparedStatement pstms = db.getConn().prepareStatement(sql);
            pstms.setString(1,task.getTitle());
            pstms.setString(2,task.getContent());
            pstms.setString(3,task.getDispatchTime());
            pstms.setString(4,task.getDeadline());
            pstms.setInt(5,task.getTeacher());
            result = pstms.executeUpdate();

            String select = "SELECT * FROM teatask WHERE Title=? AND Teacher=? AND DispatchTime=?;";
            pstms = db.getConn().prepareStatement(select);
            pstms.setString(1,task.getTitle());
            pstms.setInt(2,task.getTeacher());
            pstms.setString(3,task.getDispatchTime());
            ResultSet rs = pstms.executeQuery();
            while(rs.next())
                task.setId(rs.getInt("ID"));


            for(Student i:students){
                String insert = "INSERT INTO stutask(ID,Student) VALUES(?,?);";
                pstms = db.getConn().prepareStatement(insert);
                pstms.setInt(1,task.getId());
                pstms.setInt(2,i.getAccount());
                pstms.executeUpdate();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        if(result!=0)
            return true;
        else
            return false;
    }

    @Override
    public DefaultTableModel teaGetTask(User user) {
        String sql = "SELECT * FROM teatask WHERE Teacher=? ORDER BY DispatchTime;";
        String[] title = {"任务状态","任务编号","任务标题","任务内容","发布日期","截止日期"};
        DefaultTableModel defaultTableModel = new DefaultTableModel(title,0);
        try {
            PreparedStatement pstms = db.getConn().prepareStatement(sql);
            pstms.setInt(1, user.getAccount());
            ResultSet rs = pstms.executeQuery();
            Datetime datetime = new Datetime();
            if(rs!=null){
                while(rs.next()){
                    String status = "";
                    // 判断任务是否结束
                    if(datetime.compare(datetime.now(),rs.getString("Deadline"))==1)
                        status = "已结束";
                    else
                        status = "未结束";
                    String[] data = {status,
                            rs.getString("ID"),
                            rs.getString("Title"),
                            rs.getString("Content"),
                            rs.getString("DispatchTime"),
                            rs.getString("Deadline")
                    };
                    defaultTableModel.addRow(data);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return defaultTableModel;
    }

    @Override
    public ArrayList<Task> teaGetSurviveTask(User user) {
        ArrayList<Task> tasks = new ArrayList<>();
        String sql = "SELECT * FROM teatask WHERE Teacher=? and Deadline>?;";
        try{
            PreparedStatement pstms = db.getConn().prepareStatement(sql);
            pstms.setInt(1,user.getAccount());
            pstms.setString(2,new Datetime().now());
            ResultSet rs = pstms.executeQuery();
            while(rs.next()){
                Task task = new Task(rs.getInt("ID"),
                        rs.getString("Title"),
                        rs.getString("Content"),
                        rs.getString("DispatchTime"),
                        rs.getString("Deadline"),
                        rs.getInt("Teacher"));
                tasks.add(task);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return tasks;
    }

    public ArrayList<Task> teaAllGetTask(User user){
        ArrayList<Task> tasks = new ArrayList<>();
        String sql = "SELECT * FROM teatask WHERE Teacher=?;";
        try{
            PreparedStatement pstms = db.getConn().prepareStatement(sql);
            pstms.setInt(1,user.getAccount());
            ResultSet rs = pstms.executeQuery();
            while(rs.next()){
                Task task = new Task(rs.getInt("ID"),
                        rs.getString("Title"),
                        rs.getString("Content"),
                        rs.getString("DispatchTime"),
                        rs.getString("Deadline"),
                        rs.getInt("Teacher"));
                tasks.add(task);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return tasks;
    }

    @Override
    public ArrayList<Student> teaGetStu(User user) {
        ArrayList<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM student WHERE College=? AND Class=?;";
        try{
            PreparedStatement pstms = db.getConn().prepareStatement(sql);
            pstms.setString(1,user.getCollege());
            pstms.setString(2,user.getsClass());
            ResultSet rs = pstms.executeQuery();
            while(rs.next()){
                Student student = new Student(
                        rs.getInt("Account"),
                        rs.getString("Password"),
                        rs.getString("Name"),
                        rs.getString("Sex"),
                        rs.getInt("Age"),
                        rs.getString("IdCard"),
                        rs.getString("Telphone"),
                        rs.getString("Image"),
                        rs.getString("College"),
                        rs.getString("Class"),
                        rs.getString("LastOnline"),"student");
                students.add(student);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public String getStuPath(int task, int stu) {
        String result = null;
        String sql = "SELECT * FROM stutask WHERE ID=? AND Student=?;";
        try{
            PreparedStatement pstms = db.getConn().prepareStatement(sql);
            pstms.setInt(1,task);
            pstms.setInt(2,stu);
            ResultSet rs = pstms.executeQuery();
            while(rs.next())
                result = rs.getString("Path");
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
