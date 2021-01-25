import javax.jws.WebService;

@WebService(targetNamespace = "http://polytech.nancy.fr")
public class MonService {
    public double Convertir(double mt) {
        return mt*1.6;
    }
}
