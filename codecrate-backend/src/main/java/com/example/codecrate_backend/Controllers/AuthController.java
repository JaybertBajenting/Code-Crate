package com.example.codecrate_backend.Controllers;


import com.example.codecrate_backend.DTOs.AuthDTOs.Request.RegisterRequestDTO;
import com.example.codecrate_backend.Services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequestDTO requestDTO) {
        try{
            return ResponseEntity.ok(authService.register(requestDTO));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }




}
