package personne;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Classe <i>Personne</i> qui implemente l'interface <i>Serializable</i>
 */
@XmlRootElement
public class Personne implements Serializable {
    private int numero;
    private String nom;
    private String prenom;

    public Personne() {}

    public Personne(int n, String nom, String prenom) {
        super();
        this.numero = n;
        this.nom = nom;
        this.prenom = prenom;
    }

    public int getNumero() { return numero; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }

    public void setNumero(int numero) { this.numero = numero; }
    public void setNom(String nom) { this.nom = nom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    @Override
    public String toString() {
        return "Personne{" +
                "numero=" + numero +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }
}
