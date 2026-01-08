package com.example.demo.dto;

public class PersonDTO {

    private Integer id;
    private String name;
    private int age;

    public PersonDTO() {}

    public PersonDTO(Integer id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // ✅ GETTERS
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // ✅ SETTERS
    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
