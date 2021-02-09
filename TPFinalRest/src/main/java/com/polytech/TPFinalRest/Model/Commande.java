package com.polytech.TPFinalRest.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "commande")
public class Commande implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(targetEntity = Client.class)
    @JoinColumn(name = "id_client", referencedColumnName = "id")
    private Client id_client;

    @Column(name = "paye")
    private boolean paye;

    @OneToMany(targetEntity=Ligne_Commande.class, mappedBy="id_commande")
    private List<Ligne_Commande> ligne_commandes = new ArrayList<>();

    public Commande() { super(); }

    public Commande(Client id_client, boolean paye) {
        super();
        this.id_client = id_client;
        this.paye = paye;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getId_client() {
        return id_client;
    }

    public void setId_client(Client id_client) {
        this.id_client = id_client;
    }

    public boolean getPaye() {
        return paye;
    }

    public void setPaye(boolean paye) {
        this.paye = paye;
    }

    public List<Ligne_Commande> getLigne_commandes() { return ligne_commandes; }

    public void setLigne_commandes(List<Ligne_Commande> ligne_commandes) { this.ligne_commandes = ligne_commandes; }
}
