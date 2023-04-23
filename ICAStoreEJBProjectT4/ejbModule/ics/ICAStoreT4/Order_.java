package ics.ICAStoreT4;

	


	import java.io.Serializable;



	import jakarta.persistence.Column;
	import jakarta.persistence.Entity;
	import jakarta.persistence.Id;
	import jakarta.persistence.JoinColumn;
	import jakarta.persistence.ManyToOne;
	import jakarta.persistence.NamedQueries;
	import jakarta.persistence.NamedQuery;
	import jakarta.persistence.Table;

	@Entity
	@NamedQueries({
	      @NamedQuery(name = "Order_.findAll", query = "SELECT o FROM Order_ o"),
	      @NamedQuery(name = "Order_.findByOrderId", query = "SELECT o FROM Order_ o WHERE o.orderId = :id")
	})
	@Table(name = "Order_")


	public class Order_ implements Serializable {
		
		
		
		
		private int orderId;
		private String orderDate;
		private Store store;
		private Customer customer;
		private String paymentMethod;
		
		@Id
		@Column (name = "OrderID")
		public int getOrderId() {
			return orderId;
		}
		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}
		@Column (name = "OrderDate")
		public String getOrderDate() {
			return orderDate;
		}
		public void setOrderDate(String orderDate) {
			this.orderDate = orderDate;
		}
		@ManyToOne
	    @JoinColumn(name = "CustomerID", referencedColumnName = "CustomerID")
	    public Customer getCustomer() {
	        return customer;
	    }

	    public void setCustomer(Customer customer) {
	        this.customer = customer;
	    }
		
		@ManyToOne
	    @JoinColumn(name = "SupermarketID")
	    public Store getStore() {
	        return store;
	    }

	    public void setStore(Store store) {
	        this.store = store;
	    }
		@Column (name = "PaymentMethod")
		public String getPaymentMethod() {
			return paymentMethod;
		}
		public void setPaymentMethod(String paymentMethod) {
			this.paymentMethod = paymentMethod;
		}
		
		
		

	}



