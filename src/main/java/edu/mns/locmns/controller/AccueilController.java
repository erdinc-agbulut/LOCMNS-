package edu.mns.locmns.controller;

import edu.mns.locmns.model.Personne;
import edu.mns.locmns.security.JwtUtils;
import edu.mns.locmns.security.PersonneDetailsServiceLocMns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class AccueilController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PersonneDetailsServiceLocMns personneDetailsServiceLocMns;

    @Autowired
    JwtUtils jwtUtils;

    @GetMapping("/")
    public String accueil(){
        return "Bienvenue";
    }

    @PostMapping("/connexion")
    public String connexion(@RequestBody Personne personne) throws Exception{

        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(personne.getMail(), personne.getMotDePasse()));
        }catch (BadCredentialsException e){
            throw new Exception(e);
        }

        UserDetails userDetails = personneDetailsServiceLocMns.loadUserByUsername(personne.getMail());
        return jwtUtils.generateToken(userDetails);
    }

    @GetMapping("/connexion")
    public String connexion(){
        return "Tu es connecté";
    }

    @GetMapping("gestionnaire/a")
    public String con(){
        return "Tu es gestionnaire";
    }


}
