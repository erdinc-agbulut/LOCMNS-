package edu.mns.locmns.controller;

import edu.mns.locmns.model.Personne;
import edu.mns.locmns.security.JwtUtils;
import edu.mns.locmns.security.PersonneDetailsSeviceLocMns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AccueilController {



    @GetMapping("/")
    public String hello(){

        return "Serveur Spring OK";
    }

    @GetMapping("/connexion")
    public String connexion(){

        return "Connexion avec succès";
    }


}
