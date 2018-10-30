package hello;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	private static final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Autowired
	CustomerRepository repository;

	@Override
	public List<Customer> getCustomerListByLastName(String lastName) {
		return repository.findByLastName(lastName);
	}

	@Override
	public void populateCustomers() {
		log.info("Save customer");
		repository.save(new Customer("Jack", "Bauer"));
		log.info("Save customer");
		repository.save(new Customer("Chloe", "O'Brian"));
		log.info("Save customer");
		repository.save(new Customer("Kim", "Bauer"));
		log.info("Save customer");
		repository.save(new Customer("David", "Palmer"));
		log.info("Save customer");
		repository.save(new Customer("Michelle", "Dessler"));
	}
	
	public void printAllCustomers() {
		// fetch all customers
		log.info("Customers found with findAll():");
		log.info("-------------------------------");
		for (Customer customer : repository.findAll()) {
			log.info(customer.toString());
		}
		log.info("");
	}
	
	public void printSingleCustomer() {
		// fetch an individual customer by ID
		repository.findById(1L)
			.ifPresent(customer -> {
				log.info("Customer found with findById(1L):");
				log.info("--------------------------------");
				log.info(customer.toString());
				log.info("");
			});		
	}
	public void printSingleCustomerByName() {
		// fetch customers by last name
		log.info("Customer found with findByLastName('Bauer'):");
		log.info("--------------------------------------------");
		repository.findByLastName("Bauer").forEach(bauer -> {
			log.info(bauer.toString());
		});	
	}
	
	

}
