package com.dao;

import com.entity.Data;
import com.entity.Sensor;
import com.util.DBManager;

import java.sql.ResultSet;
import java.util.ArrayList;

public class DataDao {
    private DBManager db;
    public DataDao(){
        db = new DBManager();
    }

    /**
     * 获取单个传感器所有数据
     * @param sensor 传感器实体类
     * @return ArrayList 数据实体类
     */
    public ArrayList<Data> getAllData(Sensor sensor){
        ArrayList<Data> result =new ArrayList<>();
        String sql = String.format("SELECT * FROM DATA WHERE S_Tag=\"%s\" order by D_DateTime asc LIMIT 2880",sensor.getS_Tag());
        ResultSet rs = db.query(sql);
        try{
            while(rs.next()){
                Data data = new Data(rs.getDouble("D_Value"),
                        sensor.getM_Unit(),
                        sensor.getS_ID(),
                        rs.getString("S_Tag"),
                        rs.getString("D_DateTime"));
                result.add(data);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

}
