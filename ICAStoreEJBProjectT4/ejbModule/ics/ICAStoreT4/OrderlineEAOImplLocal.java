package ics.ICAStoreT4;

import java.util.List;

import jakarta.ejb.Local;

@Local
public interface OrderlineEAOImplLocal {
	public List<Orderline> findAllOrderline();
	
	

}
