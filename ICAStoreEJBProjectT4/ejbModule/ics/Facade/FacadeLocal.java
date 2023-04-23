package ics.Facade;

import java.util.List;

import ics.ICAStoreT4.Customer;

import ics.ICAStoreT4.Order_;
import ics.ICAStoreT4.Orderline;
import ics.ICAStoreT4.Product;
import ics.ICAStoreT4.ProductCategory;
import ics.ICAStoreT4.Store;
import jakarta.ejb.Local;

@Local
public interface FacadeLocal {
	
	public Product updateProduct(Product product);
	
	public Product createProduct(int productId, String productName, double price, int categoryId);
	
	public void deleteProduct(int id);
	
	public ProductCategory findByCategoryId (int id);
	
	public ProductCategory createProductCategory (ProductCategory productCategory);
	
	public ProductCategory updateProductCategory (ProductCategory productCategory);
	
	public void deleteProductCategory (int categoryId);
	
	public Customer findByCustomerId(int id);
	public Customer createCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public void deleteCustomer(int id);
	
	public Store findByStoreId(int id);
	public Store createStore(Store store);
	public Store updateStore(Store store);
	public void deleteStore(int id);
	public List<Store> findAllStores();
	
   public Order_ findOrderById(int id);
	
	public Order_ updateOrder(Order_ order);
	public void deleteOrder(int id);
	public List<Order_> findAllOrders();
	public List<Orderline> findAllOrderline();
	
	public List<Orderline>findOrderlineByOrderId(int orderId);
	public Orderline createOrderline(Orderline orderline);
	public void deleteOrderline(Orderline orderline);
	public void updateOrderline(Orderline orderline);
	
	

}