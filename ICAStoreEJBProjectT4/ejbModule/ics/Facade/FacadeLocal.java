package ics.Facade;

import java.util.List;

import org.ics.exceptions.MyICAException;

import ics.ICAStoreT4.Customer;

import ics.ICAStoreT4.Order_;
import ics.ICAStoreT4.Orderline;
import ics.ICAStoreT4.Product;
import ics.ICAStoreT4.ProductCategory;
import ics.ICAStoreT4.Store;
import jakarta.ejb.Local;

@Local
public interface FacadeLocal {
	
	public List<Product> findAllProducts() throws MyICAException;
	public Product updateProduct(Product product);
	public Product findByProductId(int id) throws MyICAException;
	public Product createProduct(int productId, String productName, double price, int categoryId) throws MyICAException;
	public void deleteProduct(int id) throws MyICAException;
	
	public List<ProductCategory> findAllProductCategory() throws MyICAException;
	public ProductCategory findByCategoryId (int id) throws MyICAException;
	public ProductCategory createProductCategory (ProductCategory productCategory);
	public ProductCategory updateProductCategory (ProductCategory productCategory);
	public void deleteProductCategory (int categoryId) throws MyICAException;
	
	public List<Customer> findAllCustomer() throws MyICAException;
	public List<Object[]> findCustomerOrders(int customerId) throws MyICAException;
	public List<Object[]> findAllCustomersOrdersAndTotalAmount() throws MyICAException;
	public Customer findByCustomerId(int id) throws MyICAException;
	public Customer findByCustomerIdForCreateMethod(int id) throws MyICAException;
	public Customer createCustomer(int customerId, String customerName, String userName, String address, int phoneNumber, String email ) throws MyICAException;
	public Customer updateCustomer(int customerId, String customerName, String userName, String address, int phoneNumber, String email) throws MyICAException;
	public void deleteCustomer(int id) throws MyICAException;
	
	
	public Store findByStoreId(int id) throws MyICAException;
	public Store createStore(Store store);
	public Store updateStore(Store store);
	public void deleteStore(int id) throws MyICAException;
	public List<Store> findAllStores() throws MyICAException;
	public List<Object[]> findSalesSummaryBySupermarketId(int supermarketId) throws MyICAException;
	public List<Object[]> findAllOrderlineDetails() throws MyICAException;
	
	public Order_ createOrder(int orderId, String orderDate, String paymentMethod, int customerId, int supermarketId) throws MyICAException;
    public Order_ findOrderById(int id) throws MyICAException;
	public Order_ updateOrder(Order_ order);
	public void deleteOrder(int id) throws MyICAException;
	public List<Order_> findAllOrders() throws MyICAException;
	
	public List<Orderline> findAllOrderline() throws MyICAException;
	public List<Orderline>findOrderlineByOrderId(int orderId) throws MyICAException;
	public List<Object[]> findOrderlineDetailsByOrderId(int orderId) throws MyICAException;
	
	public void deleteOrderline(Orderline orderline) throws MyICAException;
	public void deleteOrderlineByOrderIdAndProductId(int orderId, int productId) throws MyICAException ;
	public void updateOrderline(int orderId, int productId, int quantity) throws MyICAException;
	public Orderline createOrderline(int orderId, int productId, int orderlinenumber, int quantity) throws MyICAException;
	
	

}