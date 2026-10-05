package com.assignment2.assignment2.controller;

import com.assignment2.assignment2.enums.SortOrder;
import com.assignment2.assignment2.enums.SortType;
import com.assignment2.assignment2.model.User;
import com.assignment2.assignment2.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<String> addStudent(@RequestBody User user) {
        studentService.addStudent(user);
        return ResponseEntity.status(201).body("Student added successfully");
    }

    @GetMapping
    public ResponseEntity<ArrayList<User>> getStudents(
            @RequestParam(required = false) SortType sortType,
            @RequestParam(required = false) SortOrder sortOrder) {

        System.out.println("sortType = " + sortType);
        System.out.println("sortOrder = " + sortOrder);

        if (sortType != null && sortOrder != null) {
            studentService.sortStudents(sortType, sortOrder);
        }

        return ResponseEntity.ok(studentService.getStudents());
    }

    @DeleteMapping("/{rollNumber}")
    public ResponseEntity<String> deleteStudent(@PathVariable int rollNumber) {
        boolean deleted = studentService.deleteStudent(rollNumber);

        if (!deleted) {
            return ResponseEntity
                    .status(404)
                    .body("Student with roll number " + rollNumber + " not found");
        }

        return ResponseEntity.ok("Student deleted successfully");
    }
}