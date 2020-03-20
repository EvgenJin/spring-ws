package client;

import com.codenotfound.types.helloworld.Greeting;
import com.codenotfound.types.helloworld.Person;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class CountryServiceClient extends WebServiceGatewaySupport {
    public Greeting sayHello(String country){
        String uri = "http://localhost:8080/spring-ws/";
        Person request = new Person();
        request.setFirstName("asdasd");
        request.setLastName("asdasd");

        Greeting response =(Greeting) getWebServiceTemplate()
                .marshalSendAndReceive(uri, request);
        return response;
    }
}