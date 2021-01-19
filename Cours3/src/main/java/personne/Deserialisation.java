package personne;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Deserialisation {
    public static void main(String[] args){
        try{
            JAXBContext jc = JAXBContext.newInstance(Personne.class);
            Unmarshaller um = jc.createUnmarshaller();
            Personne p = (Personne)um.unmarshal(new File("resultat.xml"));
            System.out.println(p.getNom());
        } catch(JAXBException ex) {
            ex.printStackTrace();
        }
    }
}
