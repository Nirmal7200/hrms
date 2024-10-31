package com.hrms.hrms_project.service;

import com.hrms.hrms_project.dto.LoginDto;
import com.hrms.hrms_project.exception.InvalidCredentials;

public interface LoginService {
     void loginUser(LoginDto loginDto) throws InvalidCredentials;
}
