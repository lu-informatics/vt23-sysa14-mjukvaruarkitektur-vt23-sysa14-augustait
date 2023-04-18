package ics.Facade;

import java.util.List;

import ics.ICAStoreT4.Product;
import jakarta.ejb.Local;

@Local
public interface FacadeLocal {
	
	public Product updateProduct(Product product);
	
	public Product skapaProdukt(int productId, String productName, double price, int categoryId);
	
	public void deleteProduct(int id);

}