package com.dao;

import com.entity.User;
import com.util.DBManager;

public class UserDao {
    DBManager db;
    User user;

    public UserDao(User user){
        db=new DBManager();
        this.user=user;
    }

    public boolean editUserInfo(){
        String sql = String.format("UPDATE userinfo SET U_Email=\"%s\", U_IdCard=\"%s\", U_Telphone=\"%s\" WHERE U_ID=%s",user.getU_Email(),user.getU_Idcard(),user.getU_Telphone(),user.getU_ID());
        return db.update(sql);
    }

    public boolean editPassword(){
        String sql = String.format("UPDATE user SET U_Password=\"%s\" WHERE U_Account=\"%s\"",user.getU_Password(),user.getU_Account());
        System.out.println(sql);
        return db.update(sql);
    }

}
