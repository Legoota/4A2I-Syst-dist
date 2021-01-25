package polytech;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService(targetNamespace = "http://polytech.nancy.fr")
public class MonService {

    static List<Product>products = new ArrayList<>();
    static {
        products.add(new Product(1, "Tablette", 500));
        products.add(new Product(2, "Portable", 400));
        products.add(new Product(3, "Ordinateur", 1200));
        products.add(new Product(4, "Cable",50));
    }

    @WebMethod(operationName = "afficherProduits")
    public List<Product> AfficherProduits() { return products; }

    @WebMethod(operationName = "ajouterProduit")
    public boolean AjouterProduit(int code, String desc, double val) {
        return isInProduits(code) < 0 ? products.add(new Product(code,desc,val)) : false;
    }

    @WebMethod(operationName = "supprimerProduit")
    public boolean SupprimerProduit(int code) {
        int d = isInProduits(code);
        if(d > -1){
            products.remove(d);
            return true;
        }
        else return false;
    }

    private int isInProduits(int code) {
        int i = 0;
        for(Product p : products) {
            if(p.getCode() == code) return i;
            else i++;
        }
        return -1;
    }

    @WebMethod(operationName = "produitSuperieurAuPrix")
    public List<Product> ProduitSuperieurAuPrix(double x) {
        List<Product> res = new ArrayList<>(); // Initialisation liste retour
        for(Product p: products)
            if(p.getPrix() > x) res.add(p);
        return res;
    }

    // Annotation JAX-WS
    @WebMethod(operationName = "methodeConv")
    public double Convertir(double mt, double taux) { return mt*taux; }

    // Methode réalisant la somme entre deux double
    @WebMethod(operationName = "methodeSomme")
    public double Somme(double a, double b) { return a+b; }

    @WebMethod(operationName = "affichage")
    public Product AfficherProduit(int code) {
        int index = isInProduits(code);
        return index >= 0 ? products.get(index) : null;
    }
}
