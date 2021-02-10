package fr.polytech.demospring.demospring.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class Produit implements Serializable {
    private int code;
    private String designation;
    // equivalent de @Transient => permet de ne pas afficher le prix dans la requete
    // on peut utiliser @JsonIgnoreProperties au dessus de la classe avec les attributs a ignorer au format JSON
    @JsonIgnore
    private double prix;

    public Produit() { super(); }

    public Produit(int code, String designation, double prix) {
        super();
        this.code = code;
        this.designation = designation;
        this.prix = prix;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
