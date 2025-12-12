package com.dipak.SMS.service;

import com.dipak.SMS.model.Student;
import com.dipak.SMS.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepo repo;

    public void addStudent(Student student) {
        repo.save(student);
    }

    public String login(Student student) {
        Student student1 = repo.findByEmail(student.getEmail());
        if (student1 == null) {
            return "Account not found";
        }

        if (student.getPassword().equals(student1.getPassword())) {
            return "Login Successful...";
        } else {
            return "Enter Correct Password...";
        }
    }
}
