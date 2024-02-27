package com.example.classwork.domain;

public class Person {
    private long id;
    private String name;
    private int age;

    public Person(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person [" +
                "ID: " + id +
                " | Name: " + name +
                " | Age: " + age +
                "]\n";
    }
}
