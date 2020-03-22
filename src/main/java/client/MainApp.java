package client;

import org.example.helloservice.ObjectFactory;
import org.example.helloservice.ServiceRequest;
import org.example.helloservice.ServiceResponse;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

public class MainApp {
    public static void main(String[] args) {
        String uri = "http://localhost:8080/spring-ws";
        CountryServiceClient client = new CountryServiceClient();
        ObjectFactory factory = new ObjectFactory();
        ServiceRequest request = factory.createServiceRequest();

        request.setFirstName("asd");
        request.setLastName("ssss");

        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("http://www.example.org/HelloService");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);

        ServiceResponse greeting = (ServiceResponse) client.getWebServiceTemplate().marshalSendAndReceive(uri,request);
        
        System.out.println(greeting.getType());
    }
}
