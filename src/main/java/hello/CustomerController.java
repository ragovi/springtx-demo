package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CustomerController {
	
	private static final Logger log = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	CustomerService customerService;
	
	@Transactional
	public void go() {		
		log.info("INI **************** POPULATE ************************");
		customerService.populateCustomers();
		log.info("END **************** POPULATE ************************");
		
		log.info("INI **************** LIST ALL ************************");
		customerService.printAllCustomers();
		log.info("END **************** LIST ALL ************************");
		
		log.info("INI **************** LIST ONE (1) ********************");		
		customerService.printSingleCustomer();
		log.info("END **************** LIST ONE (1) ********************");
		
		log.info("INI **************** LIST ONE (2) ********************");	
		customerService.printSingleCustomerByName();
		log.info("END **************** LIST ONE (2) ********************");
	}

}
