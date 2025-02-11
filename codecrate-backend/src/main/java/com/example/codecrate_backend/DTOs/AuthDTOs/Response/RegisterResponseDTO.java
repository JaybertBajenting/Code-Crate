package com.example.codecrate_backend.DTOs.AuthDTOs.Response;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterResponseDTO {


    private String message;

    private String email;

    private String username;
}
