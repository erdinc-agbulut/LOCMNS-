package edu.mns.locmns.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class ContactController {

    @GetMapping("/contact")
    public void pageContact(){

    }
}
