package ics.ICAStore.Listeners;

import ics.ICAStoreT4.Customer;
import ics.ICAStoreT4.Order_;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class OrderAuditor {
	
	@PrePersist
	public void logCreate(Order_ o) {
		System.out.print("Order - ");
	System.out.print("@PrePersist id: "+ o.getOrderId());
	System.out.print(" from Order - ");
	System.out.print(o.getOrderDate() + " (Order date) ");
	System.out.print(o.getCustomer().getName() + " (Customer name ");
	System.out.print(o.getStore().getStoreName() + " (Store name");
	System.out.println(o.getPaymentMethod() + " (Payment method) ");
	
	
	
	}
	@PreUpdate
	public void logPreUpdate(Order_ o) {
	System.out.print("Customer - ");
	System.out.print("@PreUpdate id: "+ o.getOrderId());
	System.out.print(" from Order - ");
	System.out.print(o.getOrderDate() + " (Order date) ");
	System.out.print(o.getCustomer().getName() + " (Customer name ");
	System.out.print(o.getStore().getStoreName() + " (Store name");
	System.out.println(o.getPaymentMethod() + " (Payment method) ");
	}

}
