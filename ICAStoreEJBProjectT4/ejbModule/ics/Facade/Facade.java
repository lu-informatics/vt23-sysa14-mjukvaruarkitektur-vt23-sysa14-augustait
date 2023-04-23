package ics.Facade;




import java.util.List;

import org.ics.exceptions.MyICAException;

import ics.ICAStoreT4.Customer;
import ics.ICAStoreT4.CustomerEAOImplLocal;
import ics.ICAStoreT4.ICAStoreEAOImplLocal;

import ics.ICAStoreT4.OrderEAOImplLocal;
import ics.ICAStoreT4.Order_;
import ics.ICAStoreT4.Orderline;
import ics.ICAStoreT4.OrderlineEAOImplLocal;
import ics.ICAStoreT4.Product;
import ics.ICAStoreT4.ProductCategory;
import ics.ICAStoreT4.Store;
import ics.ICAStoreT4.StoreEAOImplLocal;
import jakarta.ejb.EJB;
import jakarta.ejb.Local;
import jakarta.ejb.Stateful;

/**
 * Session Bean implementation class Facade
 */
@Stateful
@Local
public class Facade implements FacadeLocal {
	
	@EJB
	private ICAStoreEAOImplLocal productEAO;
	@EJB
	private ICAStoreEAOImplLocal productCategoryEAO;
	@EJB
	private CustomerEAOImplLocal customerEAO;
	@EJB
	private StoreEAOImplLocal storeEAO;
	@EJB
	private OrderEAOImplLocal orderEAO;
	@EJB
	private OrderlineEAOImplLocal orderlineEAO;
	/**
	* Default constructor.
	*/
	public Facade() {
	// TODO Auto-generated constructor stub
	}
	

	public Product updateProduct(Product product) {
		return productEAO.updateProduct(product);
	
	}
	
	public Product createProduct(int productId, String productName, double price, int categoryId) {
	    Product newProduct = new Product();
	    newProduct.setProductId(productId);
	    newProduct.setProductName(productName);
	    newProduct.setPrice(price);
	    
	    // Find the ProductCategory entity that matches the categoryId
	    ProductCategory category = productCategoryEAO.findProductCategoryById(categoryId);
	    newProduct.setProductCategory(category);
	    
	    return productEAO.createProduct(newProduct);
	}


	
	public void deleteProduct(int id) throws MyICAException {
		try  {
		productEAO.deleteProduct(id);
		
	} catch (MyICAException e) {
		throw e;
	}
	}


	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productEAO.findAllProducts();
	}


	
	public ProductCategory createProductCategory(ProductCategory productCategory) {
		return productCategoryEAO.createProductCategory(productCategory);
		}






	public ProductCategory findByCategoryId(int categoryId) {
		// TODO Auto-generated method stub
		return productCategoryEAO.findProductCategoryById(categoryId);
	}
	
	public ProductCategory updateProductCategory(ProductCategory category) {
		return productCategoryEAO.updateProductCategory(category);
		}
		public void deleteProductCategory(int categoryId) {
		productCategoryEAO.deleteProductCategory(categoryId);
		}
		
		public Customer findByCustomerId(int id){
		
			return customerEAO.findByCustomerId(id);
			}
			
		public Customer createCustomer(Customer customer) {
			return customerEAO.createCustomer(customer);
			}
			
		public Customer updateCustomer(Customer customer) {
			return customerEAO.updateCustomer(customer);
			}
			
		public void deleteCustomer(int id) {
			customerEAO.deleteCustomer(id);
			}
			
		public Store findByStoreId(int id) {
			return storeEAO.findByStoreId(id);
		}
		
		public Store createStore(Store store) {
			return storeEAO.createStore(store);
			}
			public Store updateStore(Store store) {
			return storeEAO.updateStore(store);
			}
			public void deleteStore(int id) {
			storeEAO.deleteStore(id);
			}
			
			public List<Store> findAllStores() {
				return storeEAO.findAllStores();
			}
			
			public void deleteOrder(int id) {
				orderEAO.deleteOrder(id);
			}
			
			public List<Order_> findAllOrders() {
				return orderEAO.findAllOrders();
				
			}
			
			public Order_ updateOrder (Order_ order) {
				return orderEAO.updateOrder(order);
			}
			
//			public Order findOrderById(int id) {
//				return orderEAO.findOrderById(id);
//			}
 

			public List<Orderline> findAllOrderline() {
				return orderlineEAO.findAllOrderline();
				
			}
			
			public List<Orderline>findOrderlineByOrderId(int orderId){
				return orderlineEAO.findOrderlineByOrderId(orderId);
			}
			



			public Orderline createOrderline(Orderline orderline) {
				return orderlineEAO.createOrderline(orderline);
			}

			
			public void deleteOrderline(Orderline orderline) {
				orderlineEAO.deleteOrderline(orderline);
			}


			public void updateOrderline(Orderline orderline) {
				orderlineEAO.updateOrderline(orderline);
			}


			@Override
			public Order_ findOrderById(int id) {
				// TODO Auto-generated method stub
				return null;
			}
			
			public Order_ createOrder(int orderId, String orderDate, String paymentMethod, int supermarketId, int customerId) {
			    Order_ newOrder = new Order_();
			    newOrder.setOrderId(orderId);
			    newOrder.setOrderDate(orderDate);
			    newOrder.setPaymentMethod(paymentMethod);
			    
			    
			    Customer customer = customerEAO.findByCustomerId(customerId);
			    newOrder.setCustomer(customer);
			    Store store = storeEAO.findByStoreId(supermarketId);
			    newOrder.setStore(store);
			    
			    return orderEAO.createOrder(newOrder);
			}

			
			


			


			


		


	

}



