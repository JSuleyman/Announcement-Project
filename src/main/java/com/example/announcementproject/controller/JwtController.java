package com.example.announcementproject.controller;

import com.example.announcementproject.security.util.JwtUtil;
import com.example.announcementproject.security.model.JwtRequest;
import com.example.announcementproject.security.model.JwtResponse;
import com.example.announcementproject.service.impl.CustomUserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class JwtController {

    private final AuthenticationManager authenticationManager;

    private final CustomUserDetailsServiceImpl customUserDetailsServiceImpl;

    private final JwtUtil jwtUtil;

    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        System.out.println(jwtRequest);

        try {
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
        }catch (UsernameNotFoundException | BadCredentialsException e){
            e.printStackTrace();
            throw new Exception("Bad Credentials");
        }

        UserDetails userDetails = this.customUserDetailsServiceImpl.loadUserByUsername(jwtRequest.getUsername());

        String token = this.jwtUtil.generateToken(userDetails);
        System.out.println("JWT"+token);

        return ResponseEntity.ok(new JwtResponse(token));
    }

}
