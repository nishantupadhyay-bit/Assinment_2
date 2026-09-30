package com.assignment2.assignment2.validation;

import com.assignment2.assignment2.enums.Courses;
import com.assignment2.assignment2.model.User;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class StudentValidator {

    public void validate(User user) {
        if (user == null) {
            throw new IllegalArgumentException("Student details cannot be null");
        }

        validateName(user.getName());
        validateAge(user.getAge());
        validateAddress(user.getAddress());
        validateRollNumber(user.getRollNumber());
        validateCourses(user.getCourses());
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }

    private void validateAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be greater than 0");
        }
    }

    private void validateAddress(String address) {
        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("Address cannot be empty");
        }
    }

    private void validateRollNumber(int rollNumber) {
        if (rollNumber <= 0) {
            throw new IllegalArgumentException("Roll number must be greater than 0");
        }
    }

    private void validateCourses(Iterable<Courses> courses) {
        if (courses == null) {
            throw new IllegalArgumentException("Courses cannot be null");
        }

        HashSet<Courses> uniqueCourses = new HashSet<>();

        for (Courses course : courses) {
            if (course == null) {
                throw new IllegalArgumentException("Course cannot be null");
            }

            uniqueCourses.add(course);
        }

        if (uniqueCourses.size() != 4) {
            throw new IllegalArgumentException("Student must select exactly 4 different courses");
        }
    }
}