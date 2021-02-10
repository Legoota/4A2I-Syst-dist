package fr.polytech.demospring.demospring.Controller;

import fr.polytech.demospring.demospring.Model.Produit;
import fr.polytech.demospring.demospring.Repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    @RequestMapping(value = "produits/{id}", method = RequestMethod.GET)
    public Produit renvoyerUnProduit(@PathVariable int id){
        return new Produit(id,"portable",400.5);
    }

    @PostMapping(value = "produits")
    public ResponseEntity ajouterUnProduit(@RequestBody Produit p) {
        Produit res = this.produitRepository.save(p);
        if(res==null) return ResponseEntity.noContent().build();
        else {
            return ResponseEntity.created(
                    ServletUriComponentsBuilder.fromCurrentRequest().path("/{code}")
                            .buildAndExpand(res.getCode()).toUri()).build();
        }
    }
}
