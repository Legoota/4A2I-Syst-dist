package fr.polytech.demospring.demospring.Model;

import java.io.Serializable;

public class Produit implements Serializable {
    private int code;
    private String designation;
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
