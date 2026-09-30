package com.assignment2.assignment2.model;

import com.assignment2.assignment2.enums.Courses;

import java.util.ArrayList;

public class User implements Comparable<User> {

    private String name;
    private int age;
    private String address;
    private int rollNumber;
    private ArrayList<Courses> courses = new ArrayList<>();

    public User(String name, int age, String address, int rollNumber, ArrayList<Courses> courses) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.rollNumber = rollNumber;
        this.courses.addAll(courses);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public ArrayList<Courses> getCourses() {
        return new ArrayList<>(courses);
    }

    @Override
    public int compareTo(User user) {
        int nameComparison = this.name.compareTo(user.name);

        if (nameComparison != 0) {
            return nameComparison;
        }

        return Integer.compare(this.rollNumber, user.rollNumber);
    }
}