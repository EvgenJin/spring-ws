package client;

import org.example.helloservice.ObjectFactory;
import org.example.helloservice.ServiceRequest;
import org.example.helloservice.ServiceResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import ru.evg_springws.dao.ServiceResponseDAO;

public class MainApp {
    public static void main(String[] args) throws Exception{
      ServiceClient client = new ServiceClient();
      Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
      marshaller.setContextPath("org.example.helloservice");
      client.setMarshaller(marshaller);
      client.setUnmarshaller(marshaller);
      try {
        ServiceResponse response = client.getCountryDetails("United States");
        System.out.println("greeting>>>>>>"+response.getGreeting());
        System.err.println("type>>>>>>"+response.getType());
      }
      catch (Exception e) {
          System.err.println("asdaaa"+e);
      }		
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-database.xml");
//		ServiceResponseDAO employeeDAO = (ServiceResponseDAO)applicationContext.getBean("ServiceResponseDAO");			
//		ServiceResponse retrievedEmployee = employeeDAO.getServiceResponse();
//		System.out.println(">>>>>>>>RETURN :: " + retrievedEmployee.getGreeting());
    }
      
}
