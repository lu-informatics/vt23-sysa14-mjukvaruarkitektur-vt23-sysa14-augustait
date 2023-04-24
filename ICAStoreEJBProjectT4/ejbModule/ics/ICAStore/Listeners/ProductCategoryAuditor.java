package ics.ICAStore.Listeners;

import ics.ICAStoreT4.ProductCategory;
import ics.ICAStoreT4.Store;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class ProductCategoryAuditor {
	
	@PrePersist
	public void logCreate(ProductCategory c) {
		System.out.print("Product Category - ");
	System.out.print("@PrePersist id: "+ c.getCategoryId());
	System.out.print(" from Product Category - ");
	System.out.println(c.getCategoryName());
	
	}
	@PreUpdate
	public void logPreUpdate(ProductCategory c) {
	System.out.print("Product Category - ");
	System.out.print("@PreUpdate id: "+ c.getCategoryId());
	System.out.print(" from Product Category - ");
	System.out.println(c.getCategoryName());
	}

}
