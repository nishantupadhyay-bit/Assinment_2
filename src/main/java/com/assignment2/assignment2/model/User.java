package com.assignment2.assignment2.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User implements Comparable<User> {

    private String name;
    private int age;
    private String address;
    private int rollNumber;
    private List<String> courses;

    public User() {
    }

    public User(String name, int age, String address, int rollNumber, List<String> courses) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.rollNumber = rollNumber;
        setCourses(courses);
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        if (courses == null) {
            this.courses = null;
            return;
        }

        this.courses = Collections.unmodifiableList(new ArrayList<>(courses));
    }

    @Override
    public int compareTo(User other) {
        int nameComparison = this.name.compareToIgnoreCase(other.name);

        if (nameComparison != 0) {
            return nameComparison;
        }

        return Integer.compare(this.rollNumber, other.rollNumber);
    }
}
