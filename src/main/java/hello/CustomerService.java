package hello;

import java.util.List;

public interface CustomerService {
	
	 List<Customer> getCustomerListByLastName(String lastName);
	 
	 void populateCustomers();
	 
	 void printAllCustomers(); 
	 
	 void printSingleCustomer(); 
	 
	 void printSingleCustomerByName();

}
