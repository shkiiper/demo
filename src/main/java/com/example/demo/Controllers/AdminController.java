package com.example.demo.Controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {

    @GetMapping("/admin")
    public String admin() {

        return "<h1>Welcome Admin</h1>";
    }

    @GetMapping("/auth/admin")
    public String adminJWT() {

        return "<h1>Welcome Admin. You authenticated with JWT</h1>";
    }

}