package com.dipak.SMS.repository;

import com.dipak.SMS.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin, String> {
    Admin findByMail(String mail);
}
