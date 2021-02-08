package com.polytech.TPFinalRest.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product")
public class Product implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private double prix;
    @OneToOne
    @JoinColumn(name = "fabrication", referencedColumnName = "id")
    private Fabrication fabrication;

    public Product() { super(); }

    public Product(String nom, double prix, Fabrication fabrication) {
        super();
        this.nom = nom;
        this.prix = prix;
        this.fabrication = fabrication;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Fabrication getFabrication() {
        return fabrication;
    }

    public void setFabrication(Fabrication fabrication) {
        this.fabrication = fabrication;
    }
}
