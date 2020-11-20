package com.example.demo.AdminRepository;

import com.example.demo.pojo.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public interface AdminRepository extends JpaRepository<Admin, Long> {

    Admin findByAdminId(String adminId);

}
