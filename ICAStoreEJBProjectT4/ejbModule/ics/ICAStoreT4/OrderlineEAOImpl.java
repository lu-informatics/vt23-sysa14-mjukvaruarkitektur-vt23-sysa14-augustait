package ics.ICAStoreT4;

import java.util.List;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * Session Bean implementation class OrderlineEAOImpl
 */
@Stateless
@LocalBean
public class OrderlineEAOImpl implements OrderlineEAOImplLocal {
	
	@PersistenceContext(unitName = "LabEJBSql")
	private EntityManager em;


    /**
     * Default constructor. 
     */
    public OrderlineEAOImpl() {
        // TODO Auto-generated constructor stub
    }
    
    public List<Orderline> findAllOrderline() {
    	return em.createNamedQuery("Orderline.findAll", Orderline.class).getResultList();
    	}
    
    public List<Orderline> findOrderlineByOrderId(int orderId) {
        return em.createNamedQuery("Orderline.findByOrderId", Orderline.class)
                .setParameter("id", orderId)
                .getResultList();
    }
    
    public Orderline createOrderline (Orderline orderline) {
    	em.persist(orderline);
    	return orderline;
    }
    public void updateOrderline (Orderline orderline) {
    	em.merge(orderline);
    	
    }
    public void deleteOrderline(Orderline orderline) {
        Orderline mergedOrderline = em.merge(orderline);
        em.remove(mergedOrderline);
    }
    
    

}
