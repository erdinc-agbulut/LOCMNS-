package edu.mns.locmns.model;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Modele {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idModele;

    private String nomModele;

    @ManyToMany
    private List<Caracteristique> listcaracteristique = new ArrayList<>();

    @ManyToOne
    private Marque marque;

    @ManyToOne
    private TypeMateriel typeMateriel;

    @OneToMany(mappedBy = "modele")
    private Materiel materiel;

    public Integer getIdModele() {
        return idModele;
    }

    public void setIdModele(Integer idModele) {
        this.idModele = idModele;
    }

    public String getNomModele() {
        return nomModele;
    }

    public void setNomModele(String nomModele) {
        this.nomModele = nomModele;
    }
}
