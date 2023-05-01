package ics.ICAStoreT4;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;

public class OrderlineId implements Serializable  {
	
	private int productId;
	private int orderId;
	
	public OrderlineId() {

}
	public OrderlineId(int productId, int orderId) {
		
		this.productId = productId;
		this.orderId = orderId;
	}
	    @Column(name = "ProductID", nullable = false)
		@NotNull
		public int getProductId() {
			return productId;
		}
		
		public void setProductId(int productId) {
			this.productId = productId;
			
		}
		
		 @Column(name = "OrderID", nullable = false)
			@NotNull
			public int getOrderId() {
				return orderId;
			}
			
			public void setOrderId(int orderId) {
				this.orderId = orderId;
				
			}
			
			public boolean equals(Object other) {
				if ((this == other))
					return true;
			
			if ((other == null))
				return false;
			
			if (!(other instanceof OrderlineId))
				return false;
				
		OrderlineId castOther = (OrderlineId) other;
		
		return productId == castOther.productId && orderId == castOther.orderId;
		
	}
			
			
			public int hashCode() {
			    return Objects.hash(productId, orderId);
			}
}

