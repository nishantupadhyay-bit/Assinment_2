package com.assignment2.assignment2.service;

import com.assignment2.assignment2.model.User;
import com.assignment2.assignment2.validation.StudentValidator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {

    private final ArrayList<User> students = new ArrayList<>();
    private final StudentValidator studentValidator;

    public StudentService(StudentValidator studentValidator) {
        this.studentValidator = studentValidator;
    }

    public void addStudent(User user) {
        studentValidator.validate(user);

        if (isRollNumberExists(user.getRollNumber())) {
            throw new IllegalArgumentException("Roll number already exists");
        }

        students.add(user);
        students.sort(null);
    }

    public ArrayList<User> getStudents() {
        return new ArrayList<>(students);
    }

    private boolean isRollNumberExists(int rollNumber) {
        for (User student : students) {
            if (student.getRollNumber() == rollNumber) {
                return true;
            }
        }

        return false;
    }
}