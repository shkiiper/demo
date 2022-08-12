package com.example.demo.Controllers;

import com.example.demo.Entity.AuthJwtUser;
import com.example.demo.Security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping ("/login")
    public String login(){
        return "login";
    }


    @PostMapping ("/auth")
    @ResponseBody
    public String generateToken(@RequestBody AuthJwtUser authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("invalid username/password");
            }

        return jwtUtil.generateToken(authRequest.getUserName());
    }
}
