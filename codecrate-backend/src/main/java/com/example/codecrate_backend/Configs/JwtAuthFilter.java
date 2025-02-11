package com.example.codecrate_backend.Configs;


import com.example.codecrate_backend.Services.JwtService;
import com.example.codecrate_backend.Services.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    private final UserService userService;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        final String token = getCookiesValue(request);
        String userEmail;

        if(token == null){
            filterChain.doFilter(request,response);
            return;
        }
        userEmail = jwtService.extractUsername(token);


        if(userEmail != null){
            UserDetails userDetails = userService.loadUserByUsername(userEmail);
            if(jwtService.isTokenValid(token,userEmail)){
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,null,userDetails.getAuthorities()
                );
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        filterChain.doFilter(request,response);
    }


    private String getCookiesValue(HttpServletRequest request){

        if(request.getCookies() != null){
            for(Cookie cookie : request.getCookies()){
                if(cookie.getValue().equals("AccessToken")){
                    return cookie.getValue();
                }
            }
        }

        return null;
    }
}
