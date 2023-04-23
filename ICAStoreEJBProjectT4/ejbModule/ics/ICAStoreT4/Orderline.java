package ics.ICAStoreT4;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@NamedQueries({
    @NamedQuery(name= "Orderline.findAll", query = "SELECT o FROM Orderline o"),
    @NamedQuery(name = "Orderline.findByOrderId", query = "SELECT o FROM Orderline o WHERE o.id.orderId = :id")
})
@Table(name="Orderline")
public class Orderline {

    private OrderlineId id;
    private int orderlineNumber;
    private int quantity;
    private Order_ order;
    private Product product;

    @EmbeddedId
    public OrderlineId getId() {
        return id;
    }
    public void setId(OrderlineId id) {
        this.id = id;
    }

    @Column(name = "OrderlineNumber")
    public int getOrderlineNumber() {
        return orderlineNumber;
    }
    public void setOrderlineNumber(int orderlineNumber) {
        this.orderlineNumber = orderlineNumber;
    }

    @Column(name = "Quantity")
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @ManyToOne
    @JoinColumn(name = "OrderID", referencedColumnName= "OrderID", nullable = false, insertable = false, updatable = false)
    public Order_ getOrder() {
        return order;
    }
    public void setOrder(Order_ order) {
        this.order = order;
    }

    @ManyToOne
    @JoinColumn(name = "ProductID", referencedColumnName= "ProductID", nullable = false, insertable = false, updatable = false)
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
}