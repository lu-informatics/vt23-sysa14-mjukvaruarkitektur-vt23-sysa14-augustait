package ics.ICAStoreT4;

import java.util.List;

import org.ics.exceptions.MyICAException;

import jakarta.ejb.Local;

@Local
public interface OrderEAOImplLocal {

	public Order_ findOrderById(int id) throws MyICAException;
	public Order_ createOrder(Order_ order);
	public Order_ updateOrder(Order_ order);
	public void deleteOrder(int id) throws MyICAException;
	public List<Order_>findAllOrders();

}
