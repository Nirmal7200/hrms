package com.hrms.hrms_project.service;

import com.hrms.hrms_project.dto.SignUpDto;
import com.hrms.hrms_project.exception.UserNotFoudException;


public interface SignUpService {


     void createUser(SignUpDto signUpDto) throws UserNotFoudException;


}
