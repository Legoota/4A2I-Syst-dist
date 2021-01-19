package personne;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class Serialisation {
    public static void main(String[] args) {
        try {
            JAXBContext jc = JAXBContext.newInstance(Personne.class);
            Personne p1 = new Personne(0,"test","test_prenom");
            Marshaller m = jc.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(p1, new File("resultat.xml"));
        }catch(JAXBException e) {
            e.printStackTrace();
        }
    }
}
