package ru.evg_springws.service;

import org.example.helloservice.ObjectFactory;
import org.example.helloservice.ServiceRequest;
import org.example.helloservice.ServiceResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.evg_springws.dao.ServiceResponseDAO;

@Endpoint
public class HelloServiceEndpoint {
    private static final String namespaceUri = "http://www.example.org/HelloService"; 

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-database.xml");
    ServiceResponseDAO employeeDAO = (ServiceResponseDAO)applicationContext.getBean("ServiceResponseDAO");    
    
    /**
     * 
     * @param request клиент фамилия, имя
     * @return строка1,строка2
     * @throws Exception 
     */
    
    @PayloadRoot(localPart = "ServiceRequest", namespace = namespaceUri)
    @ResponsePayload
    public ServiceResponse getService(@RequestPayload ServiceRequest request) throws Exception {
        ServiceResponse retrievedEmployee = employeeDAO.getServiceResponse();
        ObjectFactory factory = new ObjectFactory();
        ServiceResponse response = factory.createServiceResponse();
        response.setGreeting(retrievedEmployee.getGreeting());
        response.setType(retrievedEmployee.getType());
        return response;
      }  
}

