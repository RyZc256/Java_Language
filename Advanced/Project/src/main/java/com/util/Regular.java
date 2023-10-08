package com.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regular implements InterfaceRegular{
    @Override
    public boolean idCard(String data) {
        String rule = "^(\\d{6})(19|20)(\\d{2})(1[0-2]|0[1-9])(0[1-9]|[1-2][0-9]|3[0-1])(\\d{3})(\\d|X|x)?$";
        Pattern pattern = Pattern.compile(rule);
        Matcher matcher = pattern.matcher(data);
        return matcher.matches();
    }

    @Override
    public boolean telphon(String data) {
        String rule = "0?(13|14|15|17|18|19)[0-9]{9}";
        Pattern pattern = Pattern.compile(rule);
        Matcher matcher = pattern.matcher(data);
        return matcher.matches();
    }

    @Override
    public boolean teacherAccount(String data) {
        String rule = "1[0-9]{6}";
        Pattern pattern = Pattern.compile(rule);
        Matcher matcher = pattern.matcher(data);
        return matcher.matches();
    }

    @Override
    public String account(String data) {
        String[] matchRegular = {"1[0-9]{6}","[2-9]{1}[0-9]{6}"};
        String[] role = {"teacher","student"};
        int flag = -1;
        for(int i=0;i<matchRegular.length;i++){
            Pattern pattern = Pattern.compile(matchRegular[i]);
            Matcher matcher = pattern.matcher(data);
            if(matcher.matches())
                flag = i;
        }
        return role[flag];
    }
}
