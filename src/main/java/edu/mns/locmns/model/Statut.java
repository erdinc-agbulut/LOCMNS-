package edu.mns.locmns.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Statut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idStatut;

    private String role;

    public Integer getId() {
        return idStatut;
    }

    public void setId(Integer id) {
        this.idStatut = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @OneToMany(mappedBy = "statut")
    private List<Utilisateur> listeUtilisateurs = new ArrayList<>();
}
