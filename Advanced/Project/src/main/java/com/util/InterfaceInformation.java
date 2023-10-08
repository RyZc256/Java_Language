package com.util;

import com.entity.User;

import java.util.ArrayList;

public interface InterfaceInformation {
    public ArrayList<String> getAllCollege();
    public ArrayList<String> getAllClass(String college);
    public boolean upDatePhoto(User user);
    public boolean upDateInformation(User user);
    /**
     * 单个添加学生
     * @param user 学生实体
     * @return
     */
    public User singleAddStu(User user);
    public boolean delStu(User user);

}
