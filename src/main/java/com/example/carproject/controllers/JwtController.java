package com.example.carproject.controllers;

import com.example.carproject.utils.JwtUtil;
import com.example.carproject.models.JwtRequest;
import com.example.carproject.models.JwtResponse;
import com.example.carproject.services.impl.CustomUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
public class JwtController {

    private final AuthenticationManager authenticationManager;

    private final CustomUserDetailsServiceImpl customUserDetailsServiceImpl;

    private final JwtUtil jwtUtil;

    @Autowired
    public JwtController(AuthenticationManager authenticationManager, CustomUserDetailsServiceImpl customUserDetailsServiceImpl, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.customUserDetailsServiceImpl = customUserDetailsServiceImpl;
        this.jwtUtil = jwtUtil;
    }

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
