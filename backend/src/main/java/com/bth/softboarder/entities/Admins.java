package com.bth.softboarder.entities;

/**
 * Created by DIVYA on 16-09-2016.
 */
public class Admins {
    int id;
    String username;
    String emailid;
    String password;
    String confirm_password;
    String status;

    public Admins() {
        super();
    }

    public Admins(int id) {
        super();
        this.id = id;
    }

    public Admins(int id, String username, String emailid) {
        super();
        this.id = id;
        this.username = username;
        this.emailid = emailid;
    }

    public Admins(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    public Admins(String username, String password, String status) {
        super();
        this.username = username;
        this.password = password;
        this.status = status;
    }

    public Admins(int id, String username, String emailid, String password) {
        super();
        this.id = id;
        this.username = username;
        this.emailid = emailid;
        this.password = password;
    }

    public Admins(int id, String username, String emailid, String password, String confirm_password) {
        super();
        this.id = id;
        this.username = username;
        this.emailid = emailid;
        this.password = password;
        this.confirm_password = confirm_password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm_password() {
        return confirm_password;
    }

    public void setConfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
    }

    @Override
    public String toString() {
        return "Admins{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", emailid='" + emailid + '\'' +
                ", password='" + password + '\'' +
                ", confirm_password='" + confirm_password + '\'' +
                '}';
    }

}
