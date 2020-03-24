package client;


import org.example.helloservice.ServiceRequest;
import org.example.helloservice.ServiceResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class ServiceClient extends WebServiceGatewaySupport {
   public ServiceResponse getCountryDetails(String country){
      String uri = "http://localhost:8080/spring-ws/HelloService";
      ServiceRequest request = new ServiceRequest();
      request.setFirstName("name!");

      ServiceResponse response = (ServiceResponse) getWebServiceTemplate().marshalSendAndReceive(uri, request, new SoapRequestHeaderModifier());
      return response;
   }   
    
}