package com.implement.spring.security.controller;


import com.implement.spring.security.entity.AuthRequest;
import com.implement.spring.security.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
public class SecurityController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/")
    public String code(){
        return "This is your code";
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception{
        try{
            authenticationManager.authenticate(
                   new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
        }
        catch (Exception e){
            throw new Exception("invalid username/password");
        }

        return jwtUtil.generateToken(authRequest.getUserName());
    }

}
