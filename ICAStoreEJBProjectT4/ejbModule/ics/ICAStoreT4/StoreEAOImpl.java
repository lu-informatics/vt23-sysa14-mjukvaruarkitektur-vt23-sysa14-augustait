package ics.ICAStoreT4;

import java.util.List;

import org.ics.exceptions.MyICAException;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;

/**
 * Session Bean implementation class StoreEAOImpl
 */
@Stateless
@LocalBean
public class StoreEAOImpl implements StoreEAOImplLocal {
	
	@PersistenceContext (unitName = "LabEJBSql")
	private EntityManager em;

    /**
     * Default constructor. 
     */
    public StoreEAOImpl() {
    	
    	
        // TODO Auto-generated constructor stub
    }
    
	public List<Store> findAllStores() {
		return em.createNamedQuery("Store.findAll", Store.class)
		         .getResultList();
	}

	public Store findByStoreId(int id) throws MyICAException {
	    try {
	        Store store = em.createNamedQuery("Store.findBySupermarketId", Store.class)
	                .setParameter("id", id)
	                .getSingleResult();
	        return store;
	    } catch (NoResultException e) {
	        throw new MyICAException("Failed to retrieve the Store! There is no Store with the Supermarket ID: " + id);
	    }
	}


    public Store createStore(Store store) {
	em.persist(store);
	return store;
	
	
	
}
	
	public Store updateStore(Store store) {
		em.merge(store);
		return store;
		}
	
	
	public void deleteStore(int id) throws MyICAException {
		Store s = this.findByStoreId(id);
		if (s != null) {
		em.remove(s);
		
	} else {
		throw new MyICAException("Failed to delete the Store! There is no Store with the Supermarket ID: " + id);
				}
		
	}
		}




