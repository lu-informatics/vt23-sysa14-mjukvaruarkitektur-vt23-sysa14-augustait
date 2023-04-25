package ics.ICAStoreT4;

import java.util.List;

import org.ics.exceptions.MyICAException;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
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

public void deleteOrder(int id) throws MyICAException {
Order_ o = em.find(Order_.class, id);
if (o != null) {
em.remove(o);

} else {
	throw new MyICAException("Failed to delete the Order! There is no Order with the Order ID: " + id);
			}
	
}


public List<Order_> findAllOrders() {
return em.createNamedQuery("Order_.findAll", Order_.class).getResultList();
}

public Order_ findOrderById(int orderId) throws MyICAException {
    try {
        return em.createNamedQuery("Order_.findByOrderId", Order_.class)
                .setParameter("id", orderId)
                .getSingleResult();
    } catch (NoResultException e) {
        throw new MyICAException("Failed to retrieve the Order! There is no Order with the Order ID: " + orderId);
    }
}


}
