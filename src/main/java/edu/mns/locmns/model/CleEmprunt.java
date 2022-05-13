package edu.mns.locmns.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CleEmprunt implements Serializable {
    private Integer idUtilisateur;

    private Integer idMateriel;

    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Integer getIdMateriel() {
        return idMateriel;
    }

    public void setIdMateriel(Integer idMateriel) {
        this.idMateriel = idMateriel;
    }
}
