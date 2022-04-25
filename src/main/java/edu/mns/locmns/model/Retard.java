package edu.mns.locmns.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Retard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date dateAlerteRetard;

    @ManyToOne
    private Gestionnaire gestionnaire;

    @ManyToOne
    private Utilisateur utilisateur;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateAlerteRetard() {
        return dateAlerteRetard;
    }

    public void setDateAlerteRetard(Date dateAlerteRetard) {
        this.dateAlerteRetard = dateAlerteRetard;
    }
}
