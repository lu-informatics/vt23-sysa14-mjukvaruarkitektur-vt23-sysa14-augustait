package ics.ICAStoreT4;

import java.util.List;

import org.ics.exceptions.MyICAException;

import jakarta.ejb.Local;

@Local
public interface OrderlineEAOImplLocal {
	public List<Orderline> findAllOrderline() throws MyICAException;
	  public Orderline createOrderline (Orderline orderline);
	  public void updateOrderline (Orderline orderline);
	  public void deleteOrderline(Orderline orderline) throws MyICAException;
	  public void deleteOrderlineByOrderIdAndProductId(Orderline orderline) throws MyICAException;
	  public List<Orderline> findOrderlineByOrderId(int orderId) throws MyICAException;
	  public List<Object[]> findAllOrderlineDetails() throws MyICAException;
	  public Orderline findOrderlineByOrderAndProductAndLine(int orderId, int productId, int orderLineNumber) throws MyICAException;
	  public List<Orderline> findOrderlineByOrderIdandProductId(int orderId, int productId) throws MyICAException;
	  public List<Object[]> findOrderlineDetailsByOrderId(int orderId) throws MyICAException;
}
