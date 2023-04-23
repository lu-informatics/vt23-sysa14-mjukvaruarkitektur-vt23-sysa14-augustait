package ics.ICAStoreT4;

import java.util.List;

import jakarta.ejb.Local;

@Local
public interface OrderEAOImplLocal {

	public Order_ findOrderById(int id);
	public Order_ createOrder(Order_ order);
	public Order_ updateOrder(Order_ order);
	public void deleteOrder(int id);
	public List<Order_>findAllOrders();

}
