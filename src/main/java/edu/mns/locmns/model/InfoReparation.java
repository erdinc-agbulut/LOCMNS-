package edu.mns.locmns.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class InfoReparation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idInfoReparation;

    private Date datePrevueReparation;

    private String cheminDocument;

    public Integer getIdInfoReparation() {
        return idInfoReparation;
    }

    @ManyToOne
    @JoinColumn(name = "id_materiel")
    private Materiel materiel;

    public void setIdInfoReparation(Integer idInfoReparation) {
        this.idInfoReparation = idInfoReparation;
    }

    public Date getDatePrevueReparation() {
        return datePrevueReparation;
    }

    public void setDatePrevueReparation(Date datePrevueReparation) {
        this.datePrevueReparation = datePrevueReparation;
    }

    public String getCheminDocument() {
        return cheminDocument;
    }

    public void setCheminDocument(String cheminDocument) {
        this.cheminDocument = cheminDocument;
    }

    public Materiel getMateriel() {
        return materiel;
    }

    public void setMateriel(Materiel materiel) {
        this.materiel = materiel;
    }
}
