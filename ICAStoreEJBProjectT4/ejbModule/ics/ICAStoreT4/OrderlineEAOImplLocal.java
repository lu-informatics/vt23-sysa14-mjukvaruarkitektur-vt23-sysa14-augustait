package ics.ICAStoreT4;

import java.util.List;

import jakarta.ejb.Local;

@Local
public interface OrderlineEAOImplLocal {
	public List<Orderline> findAllOrderline();
	  public Orderline createOrderline (Orderline orderline);
	  public void updateOrderline (Orderline orderline);
	  public void deleteOrderline(Orderline orderline);
	  public List<Orderline> findOrderlineByOrderId(int orderId);
	
	

}
