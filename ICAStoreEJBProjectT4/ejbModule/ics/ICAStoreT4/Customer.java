package ics.ICAStoreT4;

import java.util.Set;

import ics.ICAStore.Listeners.CustomerAuditor;
import ics.ICAStore.Listeners.StoreAuditor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PostLoad;
import jakarta.persistence.Table;

@EntityListeners(CustomerAuditor.class)
@Entity
@NamedQueries({
    @NamedQuery(name= "Customer.findAll", query = "SELECT c FROM Customer c"),
    @NamedQuery(
    	    name = "Customer.getTotalAmountOfOrders",
    	    query = "SELECT c.customerId, c.name, c.address, c.userName, COUNT(o.orderId) AS totalOrders , SUM(ol.quantity * p.price) AS totalAmountOfAllOrders "
    	    		+ "FROM Order_ o "
    	    		+ "JOIN o.customer c "
   	    	     	+ "JOIN o.orderLines ol "
    	    		+ "JOIN ol.product p "
    	    		+ "WHERE c.customerId = :customerId "
    	    		+ "GROUP BY c.customerId, c.name, c.address, c.userName"),
    @NamedQuery(name = "Customer.findByCustomerId", query = "SELECT c FROM Customer c WHERE c.customerId = :customerId")

})


@Table(name = "Customer")

public class Customer {
	private static final long serialVersionUID = -564832458627912631L;
	
	
	private String name;
	
	private String userName;
	
	private String address;
	
	private int phoneNumber;
	
	private String email;
	
	private int customerId;
	
	private Set<Order_>orders;

	
	@Column(name="Name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="UserName")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	@Column(name="Address")
	public String getAddress() {
		return address;
	}

	
	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name="PhoneNumber")
	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	@Column(name="Email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Id
	@Column(name = "CustomerID", columnDefinition = "INT")
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@OneToMany(mappedBy="customer", fetch= FetchType.EAGER)
	public Set<Order_> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order_> orders) {
		this.orders = orders;
	}
	
	@PostLoad
	public void logOperation() {
		System.out.print("Customer - ");
	System.out.print("@PostLoad on id: "+ this.getCustomerId() + " (Customer ID)");
	System.out.print(" @PostLoad: " + this.getName()+ " (Customer name)" + " ");
	System.out.print(this.getUserName() + " (Username)");
	System.out.print(this.getPhoneNumber() + " (Phone number) ");
	System.out.print(this.getEmail() + " (Email) ");	
	System.out.println(" " + this.getAddress() + " (Address)");
	}
	

}