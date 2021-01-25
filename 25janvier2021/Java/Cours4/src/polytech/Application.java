package polytech;

import javax.xml.ws.Endpoint;

public class Application {
    public static void main(String[] args) {
        String url = "http://localhost:8989/";
        Endpoint.publish(url,new MonService());

        System.out.println("http://localhost:8989/?wsdl");
    }
}
