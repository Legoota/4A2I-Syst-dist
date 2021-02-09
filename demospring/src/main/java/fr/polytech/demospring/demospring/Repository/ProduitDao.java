package fr.polytech.demospring.demospring.Repository;

import fr.polytech.demospring.demospring.Model.Produit;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProduitDao implements ProduitRepository {

    public static List<Produit> produits = new ArrayList<>();
    static {
        produits.add(new Produit(1,"portable",400.5));
        produits.add(new Produit(2, "pc", 1200));
        produits.add(new Produit(3, "tablette", 600));
        produits.add(new Produit(4,"telephone",500.4));
    }
    @Override
    public List<Produit> findAll() {
        return produits;
    }

    @Override
    public Produit findById(int id) {
        for(Produit p: produits){
            if(p.getCode() == id) return p;
        }
        return null;
    }

    @Override
    public Produit save(Produit produit) {
        return null;
    }
}
