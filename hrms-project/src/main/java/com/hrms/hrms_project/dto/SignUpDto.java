package com.hrms.hrms_project.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpDto {


    @NotNull
    @NotBlank
    private String name;

    @Email
    @NotBlank
    @NotNull
    private String email;

    @NotNull
    @NotBlank
    @Length(min = 6, max = 10)
    private String password;
}
