package com.hrms.hrms_project.service.Impl;

import com.hrms.hrms_project.dto.SignUpDto;
import com.hrms.hrms_project.entity.User;
import com.hrms.hrms_project.exception.UserNotFoudException;
import com.hrms.hrms_project.repository.SignUpRepository;
import com.hrms.hrms_project.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private SignUpRepository signUpRepository;

    @Override
    public void createUser(SignUpDto signUpDto) throws UserNotFoudException {


        List<User> emailList =  signUpRepository.findByEmail(signUpDto.getEmail());

            if (emailList.size()>0){
                throw new UserNotFoudException("Email already found in the database");
            }
            User user = new User();

            user.setName(signUpDto.getName());
            user.setEmail(signUpDto.getEmail());
            user.setPassword(signUpDto.getPassword());
            signUpRepository.save(user);
    }


}
