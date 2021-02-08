package com.polytech.TPFinalRest.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "fabrication")
public class Fabrication implements Serializable {

    @Id
    @Column(name = "id")
    @OneToOne(mappedBy = "fabrication")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double prix_coutant;
    private String matiere;
    private int temps_fabrication;

    public Fabrication() { super(); }

    public Fabrication(double prix_coutant, String matiere, int temps_fabrication) {
        super();
        this.prix_coutant = prix_coutant;
        this.matiere = matiere;
        this.temps_fabrication = temps_fabrication;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrix_coutant() {
        return prix_coutant;
    }

    public void setPrix_coutant(double prix_coutant) {
        this.prix_coutant = prix_coutant;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public int getTemps_fabrication() {
        return temps_fabrication;
    }

    public void setTemps_fabrication(int temps_fabrication) {
        this.temps_fabrication = temps_fabrication;
    }
}
