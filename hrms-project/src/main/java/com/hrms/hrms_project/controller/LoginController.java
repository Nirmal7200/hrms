package com.hrms.hrms_project.controller;


import com.hrms.hrms_project.dto.LoginDto;
import com.hrms.hrms_project.dto.MessageDto;
import com.hrms.hrms_project.exception.InvalidCredentials;
import com.hrms.hrms_project.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login-user")
    public ResponseEntity<MessageDto> loginUser(@RequestBody LoginDto loginDto) {
        MessageDto messageDto = new MessageDto();

        try {
            loginService.loginUser(loginDto);
            messageDto.setMessage("User Login successfully");
            return new ResponseEntity<>(messageDto, HttpStatus.OK);
        } catch (InvalidCredentials ex) {
            System.out.println("Incorrect credentials" + ex.getMessage());
            messageDto.setMessage("Incorrect User mail or password");
            return new ResponseEntity<>(messageDto, HttpStatus.BAD_REQUEST);
        }
    }
}
