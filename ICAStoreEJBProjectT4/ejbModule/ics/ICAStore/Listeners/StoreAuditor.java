package ics.ICAStore.Listeners;

import ics.ICAStoreT4.Store;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class StoreAuditor {
	
	@PrePersist
	public void logCreate(Store s) {
	System.out.print("@PrePersist id: "+s.getSupermarketId());
	System.out.print(" from Store - ");
	System.out.print(s.getStoreName()+ " ");
	System.out.println(s.getStoreAddress()+ " ");
	System.out.println(s.getCity()+ " ");
	System.out.println(s.getRegionName()+ " ");
	}
	@PreUpdate
	public void logPreUpdate(Store s) {
	
	System.out.print("@PreUpdate id: "+ s.getSupermarketId());
	System.out.print(" from Store - ");
	System.out.print(s.getStoreName()+ " ");
	System.out.println(s.getStoreAddress()+ " ");
	System.out.println(s.getCity()+ " ");
	System.out.println(s.getRegionName()+ " ");
	}
	}


