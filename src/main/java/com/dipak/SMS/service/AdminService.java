package com.dipak.SMS.service;

import com.dipak.SMS.model.Admin;
import com.dipak.SMS.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminService {

    @Autowired
    private AdminRepo repo;

    public void addAdmin(Admin admin){
        repo.save(admin);
    }

    public String login(Admin admin){

        Admin dbAdmin = repo.findByMail(admin.getMail());

        if (dbAdmin == null) {
            return "Account not found";
        }

        if (admin.getPassword().equals(dbAdmin.getPassword())) {
            return "Login Successful...";
        } else {
            return "Enter Correct Password...";
        }
    }
}