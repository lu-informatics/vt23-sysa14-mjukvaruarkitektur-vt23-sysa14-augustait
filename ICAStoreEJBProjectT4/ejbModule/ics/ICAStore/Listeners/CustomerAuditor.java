package ics.ICAStore.Listeners;

import ics.ICAStoreT4.Customer;
import ics.ICAStoreT4.ProductCategory;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class CustomerAuditor {
	
	@PrePersist
	public void logCreate(Customer c) {
		System.out.print("Customer - ");
	System.out.print("@PrePersist id: "+ c.getCustomerId());
	System.out.print(" from Customer - ");
	System.out.print(c.getName());
	System.out.print(c.getUserName());
	System.out.print(c.getPhoneNumber());
	System.out.print(c.getEmail());
	System.out.println(c.getAddress());
	
	
	}
	@PreUpdate
	public void logPreUpdate(Customer c) {
	System.out.print("Customer - ");
	System.out.print("@PreUpdate id: "+ c.getCustomerId());
	System.out.print(" from Customer - ");
	System.out.print(c.getName());
	System.out.print(c.getUserName());
	System.out.print(c.getPhoneNumber());
	System.out.print(c.getEmail());
	System.out.println(c.getAddress());
	}

}
