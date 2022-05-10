package edu.mns.locmns.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AccueilController {

    @GetMapping("/")
    public String hello(){

        return "Serveur Spring OK";
    }
}
