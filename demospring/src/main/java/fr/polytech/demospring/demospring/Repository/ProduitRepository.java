package fr.polytech.demospring.demospring.Repository;

import fr.polytech.demospring.demospring.Model.Produit;

import java.util.List;

public interface ProduitRepository {
    List<Produit> findAll();
    Produit findById(int id);
    Produit save(Produit produit);
}
