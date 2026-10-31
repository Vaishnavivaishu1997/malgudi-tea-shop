package com.vaishnavi.malgudi.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @GetMapping
    public String dashboard() {
        return "Welcome to Malgudi Tea Shop";
    }
}