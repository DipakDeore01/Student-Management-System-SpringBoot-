package com.dipak.SMS.service;

import com.dipak.SMS.model.Student;
import com.dipak.SMS.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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

    public List<Student> viewAllStudent() {
        return repo.findAll();
    }

    public Student viewStudentByEmail(String email) {
        return repo.findByEmail(email);
    }

    public List<Student> viewStudentByDepartment(String department){
        return repo.findByDepartment(department);
    }

    public List<Student> viewByCourse(String course){
        return repo.findByCourse(course);
    }

    public List<Student> viewByYear(int year){
        return repo.findByYear(year);
    }

    public boolean existsByEmail(String email){
        return repo.existsByEmail(email);
    }
}
