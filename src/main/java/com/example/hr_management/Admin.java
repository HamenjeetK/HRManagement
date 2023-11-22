package com.example.hr_management;

public class Admin {
    private int aid;

    private String admin;

    private String apswd;
    private String mail;

    public Admin(int aid, String admin, String apswd, String mail) {
        this.aid = aid;
        this.admin = admin;
        this.apswd = apswd;
        this.mail = mail;
    }

    public int getAid() {
        return aid;
    }

    public String getAdmin() {
        return admin;
    }

    public String getApswd() {
        return apswd;
    }

    public String getMail() {
        return mail;
    }
}
