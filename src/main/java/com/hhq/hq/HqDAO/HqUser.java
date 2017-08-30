package com.hhq.hq.HqDAO;

public class HqUser {

    private String sex;
    private String name;
    private Integer id;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {

        return "{id:"+id+",name:"+name+",sex:"+sex+"}";
    }
}
