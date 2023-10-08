package com.util;

import com.entity.Sensor;
import com.entity.Project;
import com.google.gson.JsonObject;


import java.io.InputStream;
import java.util.Properties;

public class Cloud {
    private DBManager db;

    private Network network;
    private String username;
    private String password;
    private String projectId;

    /**
     * 构造函数
     */
    public Cloud() {
        init();
    }


    /**
     * 添加项目
     * @param project 项目实体类
     * @return 布尔数组 [0] 云平台添加状态 [1] 数据库添加状态
     */
    public boolean[] addProject(Project project){
        boolean[] result = {false,false};
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("Protocol","1");
        jsonObject.addProperty("IsTrans","true");
        jsonObject.addProperty("ProjectIdOrTag",getProjectId());
        jsonObject.addProperty("Name",project.getP_Name());
        jsonObject.addProperty("Tag",project.getP_Tag());
        jsonObject.addProperty("Coordinate","");
        jsonObject.addProperty("DeviceImg","");
        jsonObject.addProperty("IsShare","true");

        try{
            String response = network.sendPost("POST","http://api.nlecloud.com/Devices",jsonObject.toString());
            //Project p = new Project();
            project.setP_Date(new Date().toDay());
            project.setP_ID(Integer.parseInt(splistResponse(response,"ResultObj")));
            String msg = splistResponse(response,"Msg");
//            System.out.println(response);
            // 云平台成功创建
            if(msg.equals("null")) {
                result[0] = true;
                // 写入数据库
                if(addProjectSql(project))
                    result[1] = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 更新项目
     * @param project 项目实体类
     * @return 布尔数组 [0] 云平台更新状态 [1] 数据库更新状态
     * 不可更改关键字：P_ID
     */
    public boolean[] updateProejct(Project project){
        boolean[] result = {false,false};
        JsonObject jsonObject = new JsonObject();
        String url = String.format("http://api.nlecloud.com/Devices/%s",project.getP_ID());
        jsonObject.addProperty("Protocol","1");
        jsonObject.addProperty("IsTrans","true");
        jsonObject.addProperty("ProjectIdOrTag",getProjectId());
        jsonObject.addProperty("Name",project.getP_Name());
        jsonObject.addProperty("Tag",project.getP_Tag());
        jsonObject.addProperty("Coordinate","");
        jsonObject.addProperty("DeviceImg","");
        jsonObject.addProperty("IsShare","true");
        try{
            String response = network.sendPost("PUT",url,jsonObject.toString());
            String msg = splistResponse(response,"Msg");
            if(msg.equals("null")){
                result[0] = true;
                if(updateProjectSql(project))
                    result[1] = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 删除项目
     * @param project 项目实体类
     * @return 布尔数组 [0] 云平台更新状态 [1] 数据库更新状态
     */
    public boolean[] delProject(Project project){
        boolean[] result = {false,false};
        String url = String.format("http://api.nlecloud.com/Devices/%s",project.getP_ID());
        try{
            String response = network.sendPost("DELETE",url,"");
            String msg = splistResponse(response,"Msg");
            if(msg.equals("null")){
                result[0] = true;
                if(delProjectSql(project))
                    result[1] = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 数据库新增项目
     * @param project 项目实体类
     * @return true新增成功 false新增失败
     */
    public boolean addProjectSql(Project project){
        String sql = String.format("INSERT INTO project(P_ID,P_Name,P_Tag,P_Date,U_ID)VALUES(%s, \"%s\", \"%s\", \"%s\", %s)",project.getP_ID(),project.getP_Name(),project.getP_Tag(),project.getP_Date(),project.getU_ID());
        if(db.update(sql))
            return true;
        else
            return false;

    }

    /**
     * 数据库删除项目
     * @param project 项目实体类
     * @return true成功删除 false删除失败
     */
    public boolean delProjectSql(Project project){
        String sql = String.format("DELETE FROM project WHERE P_ID=%s AND U_ID=\"%s\"",project.getP_ID(),project.getU_ID());
        return db.update(sql);
    }

    /**
     * 数据库更新项目
     * @param project
     * @return true成功删除 false删除失败
     */
    public boolean updateProjectSql(Project project){
        String sql = String.format("UPDATE project SET P_Name=\"%s\" WHERE P_ID=%s",project.getP_Name(),project.getP_ID());
        if(db.update(sql))
            return true;
        else
            return false;
    }

    /**
     * 添加传感器
     * @param project 项目实体类
     * @param sensor 传感器实体类
     * @return 布尔数组 [0] 云平台添加状态 [1] 数据库添加状态
     */
    public boolean[] addSensor(Project project, Sensor sensor){
        boolean[] result = {false,false};
        String url = String.format("http://api.nlecloud.com/devices/%s/Sensors",project.getP_ID());
        JsonObject jsonObject = getJson(sensor);
        try{
            String response = network.sendPost("POST",url,jsonObject.toString());
            if(splistResponse(response,"Msg").equals("null")){
                result[0] = true;
                if(addSensorSql(sensor))
                    result[1] = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 更新传感器
     * @param project 项目实体类
     * @param sensor 传感器实体类
     * @return 布尔数组 [0] 云平台添加状态 [1] 数据库添加状态
     * 不可更改关键字 S_Tag、
     */
    public boolean[] updateSensor(Project project,Sensor sensor){
        boolean[] result = {false,false};
        String url = String.format("http://api.nlecloud.com/devices/%s/Sensors/%s",project.getP_ID(),sensor.getS_Tag());
        try{
            String response = network.sendPost("PUT",url,getJson(sensor).toString());
            if(splistResponse(response,"Msg").equals("null")){
                result[0] = true;
                if(updateSensorSql(sensor))
                    result[1] = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 删除传感器
     * @param project 项目实体类
     * @param sensor 传感器实体类
     * @return 布尔数组 [0] 云平台添加状态 [1] 数据库添加状态
     */
    public boolean[] delSensor(Project project,Sensor sensor){
        boolean[] result = {false,false};
        String url = String.format("http://api.nlecloud.com/devices/%s/Sensors/%s",project.getP_ID(),sensor.getS_Tag());
        try{
            String response = network.sendPost("DELETE",url,"");
            if(splistResponse(response,"Msg").equals("null")){
                result[0] = true;
                if(delSensorSql(sensor))
                    result[1] = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * JSON 赋值(仅限Sensor方法使用
     * @param sensor 传感器实体类
     * @return JsonObject
     */
    public JsonObject getJson(Sensor sensor){
        JsonObject jsonObject = new JsonObject();
        if(sensor.getM_DataType().equals("Double")){
            jsonObject.addProperty("DataType","1");
            jsonObject.addProperty("Precision","2");
        }
        else if(sensor.getM_DataType().equals("Boolean"))
            jsonObject.addProperty("DataType","2");

        jsonObject.addProperty("Name",sensor.getS_Name());
        jsonObject.addProperty("GatewayID",sensor.getP_ID());
//        jsonObject.addProperty("Unit",sensor.getM_Unit());
        jsonObject.addProperty("Unit","");
//        jsonObject.addProperty("SuccessGo","0");
//        jsonObject.addProperty("GatewayDeviceID","0");
        jsonObject.addProperty("ApiTag",sensor.getS_Tag());
        jsonObject.addProperty("SerialNumber",sensor.getS_Serial());
        jsonObject.addProperty("TransType","0");
        jsonObject.addProperty("Wiring","4");
        jsonObject.addProperty("DeviceID",sensor.getM_ID());
        jsonObject.addProperty("ChanelAddress",sensor.getM_ID());
        if(sensor.getM_ID()==107){
            jsonObject.addProperty("ChanelAddress","2300");
        }else if(sensor.getM_ID()==106){
            jsonObject.addProperty("ChanelAddress","2200");
        }else if(sensor.getM_ID()==105){
            jsonObject.addProperty("ChanelAddress","2100");
        }
        return jsonObject;
    }

    /**
     * 数据库新增传感器
     * @param sensor 传感器实体类
     * @return
     */
    public boolean addSensorSql(Sensor sensor){
        String sql = String.format("INSERT INTO sensor (S_Name, S_Tag, S_Serial, M_ID, P_ID) VALUES (\"%s\", \"%s\", \"%s\", %s, %s)",sensor.getS_Name(),sensor.getS_Tag(),sensor.getS_Serial(),sensor.getM_ID(),sensor.getP_ID());
        return db.update(sql);
    }

    /**
     * 数据库更新传感器
     * @param sensor 传感器实体类
     * @return
     */
    public boolean updateSensorSql(Sensor sensor){
        String sql = String.format("UPDATE sensor SET S_Name=\"%s\", S_Tag=\"%s\", S_Serial=\"%s\", M_ID=%s, P_ID=%s WHERE S_ID=%s",sensor.getS_Name(),sensor.getS_Tag(),sensor.getS_Serial(),sensor.getM_ID(),sensor.getP_ID(),sensor.getS_ID());
        if(db.update(sql))
            return true;
        else
            return false;
    }

    /**
     * 数据库删除传感器
     * @param sensor 传感器实体类
     * @return
     */
    public boolean delSensorSql(Sensor sensor){
        String sql = String.format("DELETE FROM sensor WHERE S_ID=%s",sensor.getS_ID());
        return db.update(sql);
    }

    /**
     * 初始化
     * @return
     */
    public boolean init(){
        boolean result = false;
        db = new DBManager();
        try{
            // 读取指定文件内容
            Properties p = new Properties();
            InputStream is = this.getClass().getResourceAsStream("cloud_config.ini");
            p.load(is);
            // 设置用户名和密码
            setUsername(p.getProperty("username"));
            setPassword(p.getProperty("password"));
            setProjectId(p.getProperty("projectId"));
            result = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        network = new Network();
        // 获取access token
//        String response = "";
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("Account",getUsername());
        jsonObject.addProperty("Password",getPassword());
        jsonObject.addProperty("IsRememberMe","true");
        String response = "";
        try{
            response = network.sendPost("POST","http://api.nlecloud.com/Users/Login",jsonObject.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
        network.setAccessToken(splistResponse(response,"AccessToken"));
        return result;
    }

    /**
     * 寻找关键字对应的信息
     * @param response json字符串
     * @param keyword 关键字
     * @return String 关键字对应的信息
     */
    public String splistResponse(String response,String keyword){
        response = response.replace("{","");
        response = response.replace("}","");
        response = response.replace("\"","");

        String[] kvt = response.split(",");
        String[] kvp = new String[2];
        for (String i:kvt){
            kvp = i.split(":");
            if(kvp[0].equals(keyword))
                return kvp[1];
        }
        return null;
    }


    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getProjectId() {
        return projectId;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
}
