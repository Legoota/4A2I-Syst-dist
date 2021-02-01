package fr.polytech.TPRest.Models;

import java.io.Serializable;

public class Pokemon implements Serializable {
    private String nom;
    private int niveau;

    public Pokemon(){ super(); }

    public Pokemon(String n, int nv){
        super();
        this.nom = n;
        this.niveau = nv;
    }

    public String getNom() { return nom; }

    public void setNom(String nom) { this.nom = nom; }

    public int getNiveau() { return niveau; }

    public void setNiveau(int niveau) { this.niveau = niveau; }

    @Override
    public String toString() {
        return "Pokemon{" +
                "nom='" + nom + '\'' +
                ", niveau=" + niveau +
                '}';
    }
}
