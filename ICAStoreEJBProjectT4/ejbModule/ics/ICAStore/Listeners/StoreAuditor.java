package ics.ICAStore.Listeners;

import ics.ICAStoreT4.Store;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class StoreAuditor {
	
	@PrePersist
	public void logCreate(Store s) {
	System.out.print("@PrePersist id: "+s.getSupermarketId() + " (Supermarket ID) ");
	System.out.print(" from Store - ");
	System.out.print(s.getStoreName()+ "(Store name ");
	System.out.println(s.getStoreAddress()+ " (Address) ");
	System.out.println(s.getCity()+ " (City) ");
	System.out.println(s.getRegionName()+ " (Region) ");
	}
	@PreUpdate
	public void logPreUpdate(Store s) {
	
	System.out.print("@PreUpdate id: "+ s.getSupermarketId() + " (Supermakret ID) ");
	System.out.print(" from Store - ");
	System.out.print(s.getStoreName()+ " (Store name ");
	System.out.println(s.getStoreAddress()+ " (Address) ");
	System.out.println(s.getCity()+ " (City) ");
	System.out.println(s.getRegionName()+ " (Region) ");
	}
	}


