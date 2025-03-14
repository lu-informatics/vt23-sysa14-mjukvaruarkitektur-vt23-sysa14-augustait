package ics.ICAStoreT4;

import java.util.List;

import org.ics.exceptions.MyICAException;

import jakarta.ejb.Local;
import jakarta.ejb.Stateful;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;

/**
 * Session Bean implementation class CustomerEAOImpl
 */
@Stateful
@Local(CustomerEAOImplLocal.class)

public class CustomerEAOImpl implements CustomerEAOImplLocal {
	
	@PersistenceContext(unitName="LabEJBSql")
	private EntityManager em;
	

    /**
     * Default constructor. 
     */
    public CustomerEAOImpl() {
        // TODO Auto-generated constructor stub
    	
    }
    
   
    public List<Object[]> findAllCustomersOrdersAndTotalAmount() throws MyICAException {
        try {
            return em.createNamedQuery( "Customer.getTotalAmountOfOrdersForAllCustomers", Object[].class)
                     .getResultList();
        } catch (Exception e) {
            throw new MyICAException("Failed to retrieve the list of customers: " + e.getMessage());
        }
    }
    	
    public List<Customer> findAllCustomers() throws MyICAException {
        try {
            return em.createNamedQuery("Customer.findAll", Customer.class)
                     .getResultList();
        } catch (Exception e) {
            throw new MyICAException("Failed to retrieve the list of customers: " + e.getMessage());
        }
    }
    
    public List<Object[]> findCustomerOrders(int customerId) throws MyICAException {
        try {
            return em.createNamedQuery("Customer.getTotalAmountOfOrders", Object[].class)
                     .setParameter("customerId", customerId)
                     .getResultList();
        } catch (Exception e) {
            throw new MyICAException("Failed to retrieve the customer orders: " + e.getMessage());
        }
    }
    


    	
  
    //Denna används när vi skapar Order
    public Customer findByCustomerId(int id) throws MyICAException{ 
    	try {
    		Customer customer = em.createNamedQuery("Customer.findByCustomerId", Customer.class)
        			.setParameter("customerId", id).
        			getSingleResult();
    		return customer;
    	
    } catch (NoResultException e) {
        throw new MyICAException("Failed to retrieve the Customer! There is no Customer with the Customer ID: " + id);
    }
}
    
    //Denna används när vi skapara Customer
    public Customer findByCustomerIdForCreateMethod(int id) throws MyICAException{ 
    	try {
    		Customer customer = em.createNamedQuery("Customer.findByCustomerId", Customer.class)
        			.setParameter("customerId", id).
        			getSingleResult();
    		return customer;
    	
    	} catch (NoResultException ex) {
           
            return null;
        }
    }
    	 
    	
    	
    	
    
    	
    
    public Customer createCustomer(Customer customer) {
    	em.persist(customer);
    	return customer;
    	
    }
    	
    	public Customer updateCustomer(Customer customer) {
    		em.merge(customer);
    		return customer;
    		}
    	
    	
    	public void deleteCustomer(int id) throws MyICAException {
    		Customer a = this.findByCustomerId(id);
    		if (a != null) {
    		em.remove(a);
    		
    	} else {
    		throw new MyICAException("Failed to delete the Customer! There is no Customer with the Customer ID: " + id);
    				}
    		
    	}
    		}

