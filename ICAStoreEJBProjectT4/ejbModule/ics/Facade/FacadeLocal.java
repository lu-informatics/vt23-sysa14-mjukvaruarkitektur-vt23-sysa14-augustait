package ics.Facade;

import java.util.List;

import ics.ICAStoreT4.Product;
import ics.ICAStoreT4.ProductCategory;
import jakarta.ejb.Local;

@Local
public interface FacadeLocal {
	
	public Product updateProduct(Product product);
	
	public Product skapaProdukt(int productId, String productName, double price, int categoryId);
	
	public void deleteProduct(int id);
	
	public ProductCategory findByCategoryId (int id);
	
	public ProductCategory createProductCategory (ProductCategory productCategory);
	
	public ProductCategory updateProductCategory (ProductCategory productCategory);
	
	public void deleteProductCategory (int categoryId);

}