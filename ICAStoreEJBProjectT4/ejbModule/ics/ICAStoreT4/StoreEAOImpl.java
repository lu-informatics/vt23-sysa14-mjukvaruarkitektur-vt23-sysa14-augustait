package ics.ICAStoreT4;

import java.util.List;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
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


    public Store findByStoreId(int id){ //Ändra
	return em.createNamedQuery("Store.findBySupermarketId", Store.class)
			.setParameter("id", id).
			getSingleResult();

}

    public Store createStore(Store store) {
	em.persist(store);
	return store;
	
	
	
}
	
	public Store updateStore(Store store) {
		em.merge(store);
		return store;
		}
	
	
	public void deleteStore(int id) {
		Store s = this.findByStoreId(id);
		if (s != null) {
		em.remove(s);
		}
		}

}


