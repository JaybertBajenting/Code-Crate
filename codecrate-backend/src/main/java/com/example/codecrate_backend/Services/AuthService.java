package com.example.codecrate_backend.Services;


import com.example.codecrate_backend.DTOs.AuthDTOs.Request.LoginRequestDTO;
import com.example.codecrate_backend.DTOs.AuthDTOs.Request.RegisterRequestDTO;
import com.example.codecrate_backend.DTOs.AuthDTOs.Response.LoginResponseDTO;
import com.example.codecrate_backend.DTOs.AuthDTOs.Response.RegisterResponseDTO;
import com.example.codecrate_backend.Enums.Role;
import com.example.codecrate_backend.Models.User;
import com.example.codecrate_backend.Repositories.UserRepository;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;





@Service
@RequiredArgsConstructor
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AuthenticationManager authManager;

    public RegisterResponseDTO register(RegisterRequestDTO registerRequest) {
        String username = registerRequest.getUsername();
        String email = registerRequest.getEmail();
        String password = registerRequest.getPassword();
        String displayName = registerRequest.getDisplayName();

        if(userRepository.findByEmailOrUsername(email, username).isPresent()){
            throw new EntityExistsException("User already exists");
        }
        User newUser = User.builder()
                .username(username)
                .email(email)
                .password(passwordEncoder.encode(password))
                .displayName(displayName)
                .role(Role.USER)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        userRepository.save(newUser);
        return RegisterResponseDTO.builder().message("User registered successfully").
                email(email).username(username).build();
    }



    public LoginResponseDTO login(LoginRequestDTO loginRequest) {

        try{
            authManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
            return LoginResponseDTO.builder().message("Login successful").build();
        }catch(BadCredentialsException e){
            throw new BadCredentialsException("Invalid username or password");
        }catch (Exception e){
            throw new RuntimeException("An error occurred");
        }
    }




}
