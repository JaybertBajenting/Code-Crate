package com.example.codecrate_backend.DTOs.AuthDTOs.Request;


import lombok.Data;

@Data
public class RegisterRequestDTO {


    private String email;

    private String username;

    private String password;

    private String displayName;

}

