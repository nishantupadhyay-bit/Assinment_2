package com.assignment2.assignment2.controller;

import com.assignment2.assignment2.model.User;
import com.assignment2.assignment2.service.StudentService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return ResponseEntity.status(HttpStatusCode.valueOf(200))
                .body("Student added successfully");
    }
}