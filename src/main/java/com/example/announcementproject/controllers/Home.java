package com.example.announcementproject.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {
    @RequestMapping("/welcome")
    public String welcome() {
        String text = "this is priave page ";
        text += "this is page not allowed to unauthenticated users";
        return text;
    }
}
