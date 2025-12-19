package com.dipak.SMS.controller;

import com.dipak.SMS.model.Student;
import com.dipak.SMS.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService service;

    @PostMapping("/register")
    public ResponseEntity<String> addStudent(@RequestBody Student student){
        service.addStudent(student);
        return ResponseEntity.ok("Student Added Successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Student student){
        String result = service.login(student);

        if (result.equals("Login Successful...")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> viewAllStudent() {
        List<Student> students = service.viewAllStudent();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/byEmail/{email}")
    public ResponseEntity<Student> viewStudentByEmail(@PathVariable String email) {
        Student student = service.viewStudentByEmail(email);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/byDepartment/{department}")
    public ResponseEntity<List<Student>> viewStudentByDepartment(@PathVariable String department) {
        List<Student> students = service.viewStudentByDepartment(department);
        return ResponseEntity.ok(students);
    }

    @GetMapping("/byCourse/{course}")
    public ResponseEntity<List<Student>> viewByCourse(@PathVariable String course){
        List<Student> students = service.viewByCourse(course);
        return ResponseEntity.ok(students);
    }

    @GetMapping("/byYear/{year}")
    public ResponseEntity<List<Student>> viewByCourse(@PathVariable int year){
        List<Student> students = service.viewByYear(year);
        return ResponseEntity.ok(students);
    }

    @GetMapping("/existsByEmail/{email}")
    public ResponseEntity<Boolean> existsByEmail(@PathVariable String email) {
        boolean exists = service.existsByEmail(email);
        return ResponseEntity.ok(exists);
    }

}
