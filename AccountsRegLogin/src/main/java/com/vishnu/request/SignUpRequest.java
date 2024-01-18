package com.vishnu.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SignUpRequest {

    private Integer userId;
    private String name;
    private String email;
    private String pwd;
    private String gender;

    private LocalDate dob;
    private Long phone;

    private String userType;

    private boolean pwdChanged;
}
