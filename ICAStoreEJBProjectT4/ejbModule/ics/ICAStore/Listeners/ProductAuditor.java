package ics.ICAStore.Listeners;


import ics.ICAStoreT4.Product;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class ProductAuditor {
	
	@PrePersist
	public void logCreate(Product p) {
		System.out.print("Product - ");
	System.out.print("@PrePersist id: "+ p.getProductId());
	System.out.print(" from Product - ");
	System.out.print(p.getProductName());
	System.out.print(p.getPrice());
	System.out.println(p.getProductCategory());

	
	
	
	}
	@PreUpdate
	public void logPreUpdate(Product p) {
	System.out.print("Product - ");
	System.out.print("@PreUpdate id: "+ p.getProductId());
	System.out.print(" from Product - ");
	System.out.print(p.getProductName());
	System.out.print(p.getPrice());
	System.out.println(p.getProductCategory());
	}

}


