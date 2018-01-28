package com.example.traveler.przemek1;


/**
 * Created by User on 3/14/2017.
 */

public class Autobus {
    private String name;
    private String birthday;
    private String sex;

    public Autobus(String name, String birthday, String sex) {
        this.birthday = birthday;
        this.name = name;
        this.sex = sex;
    }

    public String getIdentyfikator() {
        return birthday;
    }

    public void setIdentyfikator(String birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}