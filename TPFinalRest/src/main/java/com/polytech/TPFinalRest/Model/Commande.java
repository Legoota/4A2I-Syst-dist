package com.polytech.TPFinalRest.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "commande")
public class Commande implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Client id_client;

    @OneToMany(targetEntity = Product.class, mappedBy = "id")
    private List<Product> id_produit = new ArrayList<>();

    public Commande() { super(); }

    public Commande(Client id_client, List<Product> id_produit) {
        super();
        this.id_client = id_client;
        this.id_produit = id_produit;
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

    public List<Product> getId_produit() {
        return id_produit;
    }

    public void setId_produit(List<Product> id_produit) {
        this.id_produit = id_produit;
    }
}
