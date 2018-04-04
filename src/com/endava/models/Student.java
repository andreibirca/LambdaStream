package com.endava.models;

public class Student {
    private String name;
    private Gender gender;
    private int age;
    private Major major;

    public Student(String name, Gender gender, int age, Major major) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.major = major;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public Major getMajor() {
        return major;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", major=" + major +
                '}';
    }

}
