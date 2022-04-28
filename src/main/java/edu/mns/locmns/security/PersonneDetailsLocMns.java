package edu.mns.locmns.security;

import edu.mns.locmns.dao.GestionnaireDao;
import edu.mns.locmns.model.Gestionnaire;
import edu.mns.locmns.model.Personne;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class PersonneDetailsLocMns implements UserDetails {

    private Personne personne;
    private Boolean isGestionnaire;


    public PersonneDetailsLocMns(Personne personne, Boolean isGestionnaire) {
        this.personne = personne;
        this.isGestionnaire = isGestionnaire;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //----GESTION DES DROITS PAR HERITAGE----

        ArrayList<SimpleGrantedAuthority> listeAuthority = new ArrayList<>();



        if(isGestionnaire) {
            listeAuthority.add(new SimpleGrantedAuthority("ROLE_GESTIONNAIRE"));
        }else{
            listeAuthority.add(new SimpleGrantedAuthority("ROLE_UTILISATEUR"));
        }

        return listeAuthority;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
