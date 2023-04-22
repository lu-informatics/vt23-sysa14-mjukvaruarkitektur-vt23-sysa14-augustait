package ics.ICAStoreT4;

import java.util.List;

import jakarta.ejb.Local;

@Local
public interface OrderEAOImplLocal {

//	public Order findOrderById(int id);
	public Order createOrder(Order order);
	public Order updateOrder(Order order);
	public void deleteOrder(int id);
	public List<Order>findAllOrders();

}
