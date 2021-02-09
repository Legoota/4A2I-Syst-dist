package com.polytech.TPFinalRest.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ligne_commande")
public class Ligne_Commande implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int id_commande;

    @ManyToOne(targetEntity = Produit.class)
    @JoinColumn(name = "id_produit", referencedColumnName = "id")
    private Produit id_produit;

    public Ligne_Commande() { super(); }

    public Ligne_Commande(int id_commande, Produit id_produit) {
        super();
        this.id_commande = id_commande;
        this.id_produit = id_produit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public Produit getId_produit() {
        return id_produit;
    }

    public void setId_produit(Produit id_produit) {
        this.id_produit = id_produit;
    }
}
