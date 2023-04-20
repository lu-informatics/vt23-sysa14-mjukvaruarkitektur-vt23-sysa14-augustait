package ics.ICAStoreT4;

import java.util.List;

import jakarta.ejb.Local;

@Local
public interface CustomerEAOImplLocal {
	
	public Customer findByCustomerId(int id);
	public Customer createCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public void deleteCustomer(int id);
	public List<Customer>findAllCustomers();
	

}
