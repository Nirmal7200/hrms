package com.hrms.hrms_project.repository;

import com.hrms.hrms_project.dto.SignUpDto;
import com.hrms.hrms_project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SignUpRepository extends JpaRepository<User, Integer> {

    List<User> findByEmail(String email);


}
