package com.stuspring.one;

import java.util.Map;

public class Newerson {

    private String name;
    private String sex;
    private String age;
    private Map<String,Car> maps;


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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Map<String, Car> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Car> maps) {
        this.maps = maps;
    }

    @Override
    public String toString() {
        return "Newerson{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", maps=" + maps +
                '}';
    }
}
