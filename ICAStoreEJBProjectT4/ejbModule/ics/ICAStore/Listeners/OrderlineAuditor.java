package ics.ICAStore.Listeners;

import ics.ICAStoreT4.Orderline;
import ics.ICAStoreT4.Product;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class OrderlineAuditor {
	
	@PrePersist
	public void logCreate(Orderline o) {
		System.out.print("Orderline - ");
	System.out.print("@PrePersist id:  " + o.getId().getProductId() + "(ProductID) " + ", " + o.getId().getOrderId() + "(OrderID) " );
	System.out.print(" from Orderline - ");
	System.out.print(o.getOrderlineNumber() + " (Orderline number)");

	System.out.println(o.getQuantity() + " (Quantity)");
	
	
	
	
	
	}
	@PreUpdate
	public void logPreUpdate(Orderline o) {
	System.out.print("Orderline - ");
	System.out.print("@PreUpdate id: " + o.getId().getProductId() + "(ProductID) " + ", " + o.getId().getOrderId() + "(OrderID) " );
	System.out.print(" from Orderline - ");
	System.out.print(o.getOrderlineNumber() + " (Orderline number)");
	System.out.println(o.getQuantity() + " (Quantity)");
	}

}
