package com.assignment2.assignment2.service;

import com.assignment2.assignment2.comparator.AddressComparator;
import com.assignment2.assignment2.comparator.AgeComparator;
import com.assignment2.assignment2.comparator.NameComparator;
import com.assignment2.assignment2.comparator.RollNumberComparator;
import com.assignment2.assignment2.enums.SortOrder;
import com.assignment2.assignment2.enums.SortType;
import com.assignment2.assignment2.model.User;
import com.assignment2.assignment2.validation.StudentValidator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;

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

    public boolean deleteStudent(int rollNumber) {
        for (User student : students) {
            if (student.getRollNumber() == rollNumber) {
                students.remove(student);
                return true;
            }
        }

        return false;
    }

    public ArrayList<User> getStudents() {
        return new ArrayList<>(students);
    }

    public void sortStudents(SortType sortType, SortOrder sortOrder) {
        Comparator<User> comparator;

        switch (sortType) {
            case NAME:
                comparator = new NameComparator();
                break;

            case ROLL_NUMBER:
                comparator = new RollNumberComparator();
                break;

            case AGE:
                comparator = new AgeComparator();
                break;

            case ADDRESS:
                comparator = new AddressComparator();
                break;

            default:
                throw new IllegalArgumentException("Invalid sort type");
        }

        if (sortOrder == SortOrder.DESC) {
            comparator = comparator.reversed();
        }

        students.sort(comparator);
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