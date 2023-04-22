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
    

public Order createOrder(Order order) {
em.persist(order);
return order;
}

public Order updateOrder(Order order) {
em.merge(order);
return order;
}

public void deleteOrder(int id) {
Order o = em.find(Order.class, id);
if (o != null) {
em.remove(o);
}
}

public List<Order> findAllOrders() {
return em.createNamedQuery("OrderTable.findAll", Order.class).getResultList();
}
//
//public Order findOrderById(int orderId) {
//return em.createNamedQuery("OrderTable.findByOrderId", Order.class)
//.setParameter("id", orderId)
//.getSingleResult();
//}




}
