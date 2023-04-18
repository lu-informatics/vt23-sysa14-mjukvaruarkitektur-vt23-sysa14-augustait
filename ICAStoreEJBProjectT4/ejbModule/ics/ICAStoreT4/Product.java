package ics.ICAStoreT4;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.PostLoad;
import jakarta.persistence.Table;

@Entity
@NamedQueries({
    @NamedQuery(name= "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findByProductId", query = "SELECT p FROM Product p WHERE p.productId = :id")
})
@Table(name="Product")
//@EntityListeners(ProjectAuditor.class)
public class Product implements Serializable {
    private static final long serialVersionUID = -564832458627912631L;
    
    @Id
    @Column(name="ProductID")
    private int productId;

    @Column(name="ProductName")
    private String productName;

    @Column(name="Price")
    private double price;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="CategoryID")
    private ProductCategory productCategory;
   
    public Product() {
        // default constructor
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    @PostLoad
    public void logOperation() {
        System.out.print("@PostLoad on id: "+this.getProductId());
        System.out.print(" @PostLoad: "+this.getProductName()+" ");
        System.out.println(this.getPrice());
    }


}
