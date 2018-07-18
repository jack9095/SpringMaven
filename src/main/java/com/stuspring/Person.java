package com.stuspring;

import java.util.List;

public class Person {

    private String name;
    private String age;
    private Car car;

    private List<Car> lists;

    public Person() {
    }

    public Person(String name, String age, Car car) {
        this.name = name;
        this.age = age;
        this.car = car;
    }

    public Person(String name, String age, List<Car> lists) {
        this.name = name;
        this.age = age;
        this.lists = lists;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Car> getLists() {
        return lists;
    }

    public void setLists(List<Car> lists) {
        this.lists = lists;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", car=" + car +
                ", lists=" + lists +
                '}';
    }
}