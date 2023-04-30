package ics.ICAStoreT4;

import java.util.List;

import org.ics.exceptions.MyICAException;

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
    
    public List<Orderline> findAllOrderline() throws MyICAException {
    	try {
    	return em.createNamedQuery("Orderline.findAll", Orderline.class).getResultList();
    	 } catch (Exception e) {
             throw new MyICAException("Failed to retrieve the list of orderlines: " + e.getMessage());
         }
   	 }
    
    
    public List<Orderline> findOrderlineByOrderId(int orderId) throws MyICAException {
        List<Orderline> orderlines = em.createNamedQuery("Orderline.findByOrderId", Orderline.class)
                .setParameter("id", orderId)
                .getResultList();
        if (orderlines.isEmpty()) {
            throw new MyICAException("No orderlines found for order ID: " + orderId);
        }
        return orderlines;
    }
    
    public List<Orderline> findOrderlineByOrderIdandProductId(int orderId, int productId) throws MyICAException {
    	List<Orderline> orderlines = em.createNamedQuery("Orderline.findByOrderIdAndProductId", Orderline.class)
                .setParameter("orderId", orderId)
                .setParameter("productId", productId)
                .getResultList();
        return orderlines;
    }
    
    public Orderline findOrderlineByOrderAndProductAndLine(int orderId, int productId, int orderLineNumber) throws MyICAException {
        List<Orderline> orderlines = em.createNamedQuery("Orderline.findByOrderAndProductAndLine", Orderline.class)
                .setParameter("orderId", orderId)
                .setParameter("productId", productId)
                .setParameter("orderlineNumber", orderLineNumber)
                .getResultList();
        if (orderlines.isEmpty()) {
            throw new MyICAException("No orderlines found for order ID: " + orderId + ", product ID: " + productId + " and order line number: " + orderLineNumber);
        }
        return orderlines.get(0);
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
