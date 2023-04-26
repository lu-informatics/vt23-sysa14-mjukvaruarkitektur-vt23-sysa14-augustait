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
	
	public Product createProduct(int productId, String productName, double price, int categoryId) throws MyICAException {
	    Product newProduct = new Product();
	    newProduct.setProductId(productId);
	    newProduct.setProductName(productName);
	    newProduct.setPrice(price);
	    
	   
	    ProductCategory category;
	    try {
	        category = productCategoryEAO.findProductCategoryById(categoryId);
	    } catch (MyICAException e) {
	        throw new MyICAException("Failed to create Product! There is no category with the ID: " + categoryId);
	    }
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
	
	public Product findByProductId(int id) throws MyICAException {
	    try {
	        return productEAO.findProductByProductId(id);
	    } catch (MyICAException e) {
	        throw e;
	    }
	}


	public List<Product> findAllProducts() throws MyICAException {
		// TODO Auto-generated method stub
		try {
			return productEAO.findAllProducts();
		} catch (MyICAException e) {
			// TODO Auto-generated catch block
			throw e;
		}
	}

	
	public List<ProductCategory> findAllProductCategory() throws MyICAException {
		// TODO Auto-generated method stub
		try {
			return productCategoryEAO.findAllProductCategories();
		} catch (MyICAException e) {
			// TODO Auto-generated catch block
			throw e;
		}
	}

	
	public ProductCategory createProductCategory(ProductCategory productCategory) {
		return productCategoryEAO.createProductCategory(productCategory);
		}






	public ProductCategory findByCategoryId(int categoryId) throws MyICAException {
		try {
		return productCategoryEAO.findProductCategoryById(categoryId);
	    } catch (MyICAException e) {
	        throw e;
	    }
	}
	
	public ProductCategory updateProductCategory(ProductCategory category) {
		return productCategoryEAO.updateProductCategory(category);
		}
		public void deleteProductCategory(int categoryId) throws MyICAException {
		try {
			productCategoryEAO.deleteProductCategory(categoryId);
		} catch (MyICAException e) {
			
			throw e;
		}
		}
		
		public Customer findByCustomerId(int id) throws MyICAException{
			
			try {
				return customerEAO.findByCustomerId(id);
		    } catch (MyICAException e) {
		        throw e;
		    }
		
			
			}
		
		public List<Customer> findAllCustomer() throws MyICAException {
			// TODO Auto-generated method stub
			try {
				return customerEAO.findAllCustomers();
			} catch (MyICAException e) {
				// TODO Auto-generated catch block
				throw e;
			}
		}
			
		public Customer createCustomer(Customer customer) {
			return customerEAO.createCustomer(customer);
			}
			
		public Customer updateCustomer(Customer customer) {
			return customerEAO.updateCustomer(customer);
			}
			
		public void deleteCustomer(int id) throws MyICAException {
			try {
				customerEAO.deleteCustomer(id);
			} catch (MyICAException e) {
				// TODO Auto-generated catch block
				throw e;
			}
			}
			
		public Store findByStoreId(int id) throws MyICAException {
		    try {
		        return storeEAO.findByStoreId(id);
		    } catch (MyICAException e) {
		        throw e;
		    }
		}
	
		public Store createStore(Store store) {
			return storeEAO.createStore(store);
			}
			public Store updateStore(Store store) {
			return storeEAO.updateStore(store);
			}
			public void deleteStore(int id) throws MyICAException {
			try {
				storeEAO.deleteStore(id);
			} catch (MyICAException e) {
				// TODO Auto-generated catch block
				throw e;
			}
			}
			
			public List<Store> findAllStores() throws MyICAException {
				try {
					return storeEAO.findAllStores();
				} catch (MyICAException e) {
					// TODO Auto-generated catch block
					throw e;
				}
			}
			
			public void deleteOrder(int id) throws MyICAException {
				try {
					orderEAO.deleteOrder(id);
				} catch (MyICAException e) {
					// TODO Auto-generated catch block
					throw e;
				}
			}
			
			public List<Order_> findAllOrders() throws MyICAException {
				try {
					return orderEAO.findAllOrders();
				} catch (MyICAException e) {
					// TODO Auto-generated catch block
					throw e;
				}
				
			}
			
			public Order_ updateOrder (Order_ order) {
				return orderEAO.updateOrder(order);
			}
			
	public Order_ findOrderById(int id) throws MyICAException {
				try {
					return orderEAO.findOrderById(id);
				} catch (MyICAException e) {
					// TODO Auto-generated catch block
					throw e;
				}
		}
 

			public List<Orderline> findAllOrderline() throws MyICAException {
				try {
					return orderlineEAO.findAllOrderline();
				} catch (MyICAException e) {
					// TODO Auto-generated catch block
					throw e;
				}
				
			}
			
			public List<Orderline>findOrderlineByOrderId(int orderId) throws MyICAException{
				try {
					return orderlineEAO.findOrderlineByOrderId(orderId);
				} catch (MyICAException e) {
					// TODO Auto-generated catch block
					throw e;
				}
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


			
			public Order_ createOrder(int orderId, String orderDate, String paymentMethod, int supermarketId, int customerId) throws MyICAException {
			    try {
			        Order_ newOrder = new Order_();
			        newOrder.setOrderId(orderId);
			        newOrder.setOrderDate(orderDate);
			        newOrder.setPaymentMethod(paymentMethod);

			        Customer customer = customerEAO.findByCustomerId(customerId);
			        newOrder.setCustomer(customer);
			        Store store = storeEAO.findByStoreId(supermarketId);
			        newOrder.setStore(store);

			        return orderEAO.createOrder(newOrder);
			    } catch (Exception e) {
			        throw new MyICAException("Failed to create the order: " + e.getMessage());
			    }
			}

			
			


			


			


		


	

}



