package com.hrms.hrms_project.service.Impl;

import com.hrms.hrms_project.dto.LoginDto;
import com.hrms.hrms_project.entity.User;
import com.hrms.hrms_project.exception.InvalidCredentials;
import com.hrms.hrms_project.repository.LoginRepository;
import com.hrms.hrms_project.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public void loginUser(LoginDto loginDto) throws InvalidCredentials {
        Optional<User> userOptional = loginRepository.findByEmailAndPassword(loginDto.getEmail(), loginDto.getPassword());
        if (userOptional.isEmpty()) {
            throw new InvalidCredentials("Email or password is wrong");
        }
    }
}
