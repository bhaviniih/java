package com.example.demo.model;

public class Person {

    private String name;
    private int age;

    // Default constructor (REQUIRED for POST)
    public Person() {}

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
