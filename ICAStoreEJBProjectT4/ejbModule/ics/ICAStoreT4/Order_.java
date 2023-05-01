package ics.ICAStoreT4;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PostLoad;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import ics.ICAStore.Listeners.OrderAuditor;

@EntityListeners(OrderAuditor.class)
@Entity
@NamedQueries({
    @NamedQuery(name = "Order_.findAll", query = "SELECT o FROM Order_ o"),
    @NamedQuery(name = "Order_.findByOrderId", query = "SELECT o FROM Order_ o WHERE o.orderId = :id")
})
@Table(name = "Order_")
public class Order_ implements Serializable {

    private static final long serialVersionUID = -564832458627912631L;

    private int orderId;
    private String orderDate;
    private Store store;
    private Customer customer;
    private String paymentMethod;
    private List<Orderline> orderLines;

    @Transient
    private Customer loadedCustomer;

    @Transient
    private Store loadedStore;

    @Id
    @Column(name = "OrderID")
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Column(name = "OrderDate")
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
        this.loadedCustomer = customer;
    }

    @ManyToOne
    @JoinColumn(name = "SupermarketID")
    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
        this.loadedStore = store;
    }

    @Column(name = "PaymentMethod")
    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    
    @OneToMany(mappedBy = "order")
    public List<Orderline> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<Orderline> orderLines) {
        this.orderLines = orderLines;
    }
    

    @PostLoad
    public void logOperation() {
        System.out.print("Order - ");
        System.out.print("@PostLoad on id: " + this.getOrderId());
        System.out.print(" @PostLoad: " + this.getOrderDate() +  "(Order date) " + " ");
        System.out.print("Customer: " + this.customer.getName() + " ");
        System.out.print("Store: " + this.store.getStoreName() + " ");
        System.out.println(this.getPaymentMethod() + " (Payment method)");
    }
}



