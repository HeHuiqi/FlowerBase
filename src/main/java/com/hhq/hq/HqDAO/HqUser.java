package com.hhq.hq.HqDAO;

public class HqUser {



    private String password;
    private String username;
    private Integer id;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {

        return "{id:"+id+",name:"+username+",password:"+password+"}";
    }
}
