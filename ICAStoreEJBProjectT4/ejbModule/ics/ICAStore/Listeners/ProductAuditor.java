package ics.ICAStore.Listeners;


import ics.ICAStoreT4.Product;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class ProductAuditor {
	
	@PrePersist
	public void logCreate(Product p) {
		System.out.print("Product - ");
	System.out.print("@PrePersist id: "+ p.getProductId() + " (Product ID)");
	System.out.print(" from Product - ");
	System.out.print(p.getProductName() + " (Product name)");
	System.out.print(p.getPrice() + " (Price)");
	System.out.println(p.getProductCategory().getCategoryName() + ("Category name"));

	
	
	
	}
	@PreUpdate
	public void logPreUpdate(Product p) {
	System.out.print("Product - ");
	System.out.print("@PreUpdate id: "+ p.getProductId() + " Product ID) ");
	System.out.print(" from Product - ");
	System.out.print(p.getProductName() + " (Product name)");
	System.out.print(p.getPrice() + " (Price)");
	System.out.println(p.getProductCategory().getCategoryName() + ("Category name"));
	}

}


