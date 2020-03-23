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
//      CountryServiceClient client = new CountryServiceClient();
//      Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
//      marshaller.setContextPath("org.example.helloservice");
//      client.setMarshaller(marshaller);
//      client.setUnmarshaller(marshaller);
//      try {
//        ServiceResponse response = client.getCountryDetails("United States");      
//      }
//      catch (Exception e) {
//          System.err.println("asdaaa"+e);
//      }
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-database.xml");
		ServiceResponseDAO employeeDAO = (ServiceResponseDAO)applicationContext.getBean("employeeDAOWithJDBCTemplate");
			
		ServiceResponse retrievedEmployee = employeeDAO.getServiceResponse();
		System.out.println("Retrieved Employee :: " + retrievedEmployee.getGreeting());
    }
      
}
