package com.hrms.hrms_project.controller;

import com.hrms.hrms_project.dto.MessageDto;
import com.hrms.hrms_project.dto.SignUpDto;
import com.hrms.hrms_project.exception.UserNotFoudException;
import com.hrms.hrms_project.service.SignUpService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Validated
public class SignUpController {



    @Autowired
    private SignUpService signUpService;

    @PostMapping("/create-user")
    public ResponseEntity<MessageDto> createUser (@Valid @RequestBody SignUpDto signUpDto){


        MessageDto messageDto = new MessageDto();


        try {
            signUpService.createUser(signUpDto) ;
            messageDto.setMessage("User created successfully");
            return new ResponseEntity<>(messageDto, HttpStatus.OK);
        } catch (UserNotFoudException ex){
            System.out.println("Mail already found "+ ex.getMessage());
            messageDto.setMessage("Email already found in database");

            return new ResponseEntity<>(messageDto, HttpStatus.BAD_REQUEST);
        }


    }

}
