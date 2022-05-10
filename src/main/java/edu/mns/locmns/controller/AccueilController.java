package edu.mns.locmns.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class AccueilController {

    @GetMapping("/")
    public String accueil(){
        return "Bienvenue";
    }
}
