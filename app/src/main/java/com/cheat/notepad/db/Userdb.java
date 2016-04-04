package com.cheat.notepad.db;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/3/31 0031.
 */
public class Userdb implements Serializable {
    private int id;
    private String name;
    private String passwd;
    private String email;

    public Userdb() {
    }

    public Userdb(String name, String passwd) {
        this.name = name;
        this.passwd = passwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
