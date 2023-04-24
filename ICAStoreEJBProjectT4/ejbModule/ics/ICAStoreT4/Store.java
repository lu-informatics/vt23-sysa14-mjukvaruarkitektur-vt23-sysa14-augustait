package ics.ICAStoreT4;

import java.io.Serializable;
import java.util.List;

import ics.ICAStore.Listeners.StoreAuditor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PostLoad;
import jakarta.persistence.Table;
@EntityListeners(StoreAuditor.class)
@Entity
@NamedQueries({
    @NamedQuery(name= "Store.findAll", query = "SELECT s FROM Store s"),
    @NamedQuery(name = "Store.findBySupermarketId", query = "SELECT s FROM Store s WHERE s.supermarketId = :id")
})

@Table(name = "Store")
public class Store implements Serializable {
	
	private static final long serialVersionUID = -564832458627912631L;
	
	private String regionName;
	private int supermarketId;
	private String storeName;
	private String storeAddress;
	private String city;
	private List<Order_> orders;
	
	@Column (name = "RegionName")
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	@Id
	@Column (name = "SupermarketID")
	public int getSupermarketId() {
		return supermarketId;
	}
	public void setSupermarketId(int supermarketId) {
		this.supermarketId = supermarketId;
	}
	@Column (name = "StoreName")
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	@Column (name = "StoreAddress")
	public String getStoreAddress() {
		return storeAddress;
	}
	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}
	@Column (name = "City")
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@OneToMany(mappedBy = "store")
	public List<Order_> getOrders() {
		return orders;
	}
	
	public void setOrders(List<Order_> orders) {
		this.orders = orders;
	}
	
	@PostLoad
	public void logOperation() {
		 System.out.print("Store - ");
	System.out.print("@PostLoad on id: "+this.getSupermarketId() + " (Supermarket ID) ");
	System.out.print(" @PostLoad: " + this.getStoreName()+ " (Store name) ");
	System.out.print(this.getStoreAddress() + " (Address) ");
	System.out.print(this.getCity()+ " (City) ");
	System.out.println(" " + this.getRegionName() + " (Region) ");
	}
	
	
	

}
