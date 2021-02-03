package fr.polytech.TPRest.Models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="pokemon")
public class Pokemon implements Serializable {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private int level;

    public Pokemon(){ super(); }

    public Pokemon(String n, int nv){
        super();
        this.nom = n;
        this.level = nv;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }

    public void setNom(String nom) { this.nom = nom; }

    public int getNiveau() { return level; }

    public void setNiveau(int niveau) { this.level = niveau; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return level == pokemon.level && nom.equals(pokemon.nom);
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "nom='" + nom + '\'' +
                ", level=" + level +
                '}';
    }
}
