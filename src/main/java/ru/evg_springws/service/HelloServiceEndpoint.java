package ru.evg_springws.service;

import org.example.helloservice.ObjectFactory;
import org.example.helloservice.ServiceRequest;
import org.example.helloservice.ServiceResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class HelloServiceEndpoint {
    private static final String namespaceUri = "http://www.example.org/HelloService"; 

    
    /**
     * 
     * @param request клиент фамилия, имя
     * @return решение, тип
     * @throws Exception 
     */
    
    @PayloadRoot(localPart = "ServiceRequest", namespace = namespaceUri)
    @ResponsePayload
    public ServiceResponse getService(@RequestPayload ServiceRequest request) throws Exception {
        String greeting = request.getFirstName();
        ObjectFactory factory = new ObjectFactory();
        ServiceResponse response = factory.createServiceResponse();
        response.setGreeting(greeting);
        response.setType("asdasdads");
        return response;
      }  
}

