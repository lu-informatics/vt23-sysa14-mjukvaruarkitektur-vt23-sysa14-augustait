package ics.ICAStoreT4;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@NamedQueries({
    @NamedQuery(name= "ProductCategory.findAll", query = "SELECT pc FROM ProductCategory pc"),
    @NamedQuery(name = "ProductCategory.findByCategoryId", query = "SELECT p FROM ProductCategory p WHERE p.categoryId = :categoryId")

})


@Table(name = "ProductCategory")
public class ProductCategory {
	private int categoryId;
	private String categoryName;
	private Set<Product>products;
	
	@Id
	@Column(name = "CategoryID", columnDefinition = "INT")
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	@Column(name="CategoryName")
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	@OneToMany(mappedBy="productCategory", fetch= FetchType.EAGER)
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
}