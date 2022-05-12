package edu.mns.locmns.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ContactController {

    @GetMapping("/contact")
    public String pageContact(){
        return "Bienvenue sur la page contact";
    }
}
