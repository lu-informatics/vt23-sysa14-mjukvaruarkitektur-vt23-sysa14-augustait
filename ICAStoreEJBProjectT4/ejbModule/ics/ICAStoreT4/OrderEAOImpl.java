package ics.ICAStoreT4;

import java.util.List;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * Session Bean implementation class OrderEAOImpl
 */
@Stateless
@LocalBean
public class OrderEAOImpl implements OrderEAOImplLocal {
	
	@PersistenceContext(unitName = "LabEJBSql")
	private EntityManager em;

    /**
     * Default constructor. 
     */
    public OrderEAOImpl() {
        // TODO Auto-generated constructor stub
    }
    

public Order_ createOrder(Order_ order) {
em.persist(order);
return order;
}

public Order_ updateOrder(Order_ order) {
em.merge(order);
return order;
}

public void deleteOrder(int id) {
Order_ o = em.find(Order_.class, id);
if (o != null) {
em.remove(o);
}
}

public List<Order_> findAllOrders() {
return em.createNamedQuery("Order_.findAll", Order_.class).getResultList();
}

public Order_ findOrderById(int orderId) {
return em.createNamedQuery("Order_.findByOrderId", Order_.class)
.setParameter("id", orderId)
.getSingleResult();
}




}
