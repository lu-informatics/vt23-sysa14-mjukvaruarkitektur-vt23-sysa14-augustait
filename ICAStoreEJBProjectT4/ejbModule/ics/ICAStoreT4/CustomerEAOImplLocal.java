package ics.ICAStoreT4;

import java.util.List;

import org.ics.exceptions.MyICAException;

import jakarta.ejb.Local;

@Local
public interface CustomerEAOImplLocal {
	
	public Customer findByCustomerId(int id) throws MyICAException;
	public Customer createCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public void deleteCustomer(int id) throws MyICAException;
   public List<Customer> findAllCustomers() throws MyICAException;
   public Customer findByCustomerIdForCreateMethod(int id) throws MyICAException;
   public List<Object[]> findCustomerOrders(int customerId) throws MyICAException;
   public List<Object[]> findAllCustomersOrdersAndTotalAmount() throws MyICAException;

}
