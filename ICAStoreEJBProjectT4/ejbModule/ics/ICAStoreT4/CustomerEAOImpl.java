package ics.ICAStoreT4;

import java.util.List;

import jakarta.ejb.Local;
import jakarta.ejb.Stateful;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * Session Bean implementation class CustomerEAOImpl
 */
@Stateful
@Local
public class CustomerEAOImpl implements CustomerEAOImplLocal {
	
	@PersistenceContext(unitName="LabEJBSql")
	private EntityManager em;
	

    /**
     * Default constructor. 
     */
    public CustomerEAOImpl() {
        // TODO Auto-generated constructor stub
    	
    }
    	
    	public List<Customer> findAllCustomers() {
    		return em.createNamedQuery("Customer.findAll", Customer.class)
    		         .getResultList();
    	}


    	
  
    
    public Customer findByCustomerId(int id){ //Ändra
    	return em.createNamedQuery("Customer.findByCustomerId", Customer.class)
    			.setParameter("customerId", id).
    			getSingleResult();

}
    
    public Customer createCustomer(Customer customer) {
    	em.persist(customer);
    	return customer;
    	
    }
    	
    	public Customer updateCustomer(Customer customer) {
    		em.merge(customer);
    		return customer;
    		}
    	
    	
    	public void deleteCustomer(int id) {
    		Customer a = this.findByCustomerId(id);
    		if (a != null) {
    		em.remove(a);
    		}
    		}

}