package com.cheat.notepad.atys;

import android.content.Context;

import com.cheat.notepad.db.Mydb;


/**
 * Created by Administrator on 2016/4/1 0001.
 */
public class AtyEquals {

    public static boolean equalsNull(Context c, String s, String d){
        if (s.equals("")) {
            AtyDialog.show(c,"友情提示","用户不能为空");
            return false;
        } if(d.equals("")){
            AtyDialog.show(c,"友情提示","密码不能为空");
            return false;
        }
        return true;
    }
    public static boolean equalsNull(Context c, String s, String p,String e){
        if (s.equals("")) {
            AtyDialog.show(c,"友情提示","用户不能为空");
            return false;
        }if(p.equals("")){
            AtyDialog.show(c,"友情提示","密码不能为空");
            return false;
        }if (e.equals("")){
            AtyDialog.show(c,"友情提示","Email不能为空");
            return false;
        }
        return true;
    }

    public static boolean equalsdb(Context c, String s, String p){
        Mydb db = new Mydb(c);
        String dp=db.select(s);
        if(dp.equals("")){
            AtyDialog.show(c,"友情提示","用户不存在");
            return false;
        }if(dp.equals(p)) {
            return true;
        }
        AtyDialog.show(c,"友情提示", "用户名或密码错误");
        return false;
        }
    }

