package com.example.codecrate_backend.DTOs.AuthDTOs.Request;


import lombok.Data;

@Data
public class LoginRequestDTO {
    private String username;

    private String password;
}
