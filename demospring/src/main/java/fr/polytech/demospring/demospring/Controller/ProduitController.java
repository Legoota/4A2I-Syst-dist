package fr.polytech.demospring.demospring.Controller;

import fr.polytech.demospring.demospring.Model.Produit;
import fr.polytech.demospring.demospring.Repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Pour indiquer a Spring que c'est cette classe qui joue le role de controleur, on ajoute l'annotation suivante:
@RestController
public class ProduitController {

    // Injection des dépendances et inversion de controle
    @Autowired
    private ProduitRepository produitRepository;

    @GetMapping(value = "produits")
    public List<Produit> listeProduits() { return this.produitRepository.findAll(); }

    //endpoint /produits/{id}
    @GetMapping(value = "produits/{id}")
    public Produit renvoyerUnProduit(@PathVariable int id){
        return new Produit(id,"portable",400.5);
    }
}
