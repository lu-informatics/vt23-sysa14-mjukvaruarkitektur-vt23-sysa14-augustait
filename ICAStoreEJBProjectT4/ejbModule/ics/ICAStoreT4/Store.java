package ics.ICAStoreT4;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@NamedQueries({
    @NamedQuery(name= "Store.findAll", query = "SELECT s FROM Store s"),
    @NamedQuery(name = "Store.findBySupermarketId", query = "SELECT s FROM Store s WHERE s.supermarketId = :id")
})

@Table(name = "Store")
public class Store implements Serializable {
	
	private String regionName;
	private int supermarketId;
	private String storeName;
	private String storeAddress;
	private String city;
	private List<Order> orders;
	
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
	public List<Order> getOrders() {
		return orders;
	}
	
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	
	

}
