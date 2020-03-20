package client;

import com.codenotfound.types.helloworld.Greeting;
import com.codenotfound.types.helloworld.ObjectFactory;
import com.codenotfound.types.helloworld.Person;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

public class MainApp {
    public static void main(String[] args) {
        String uri = "http://localhost:8080/spring-ws";
        CountryServiceClient client = new CountryServiceClient();
        ObjectFactory factory = new ObjectFactory();
        Person person = factory.createPerson();

        person.setFirstName("asd");
        person.setLastName("ssss");

        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.codenotfound.types.helloworld");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);

        Greeting greeting = (Greeting) client.getWebServiceTemplate().marshalSendAndReceive(uri,person);

        System.out.println(greeting.getGreeting());
    }
}
