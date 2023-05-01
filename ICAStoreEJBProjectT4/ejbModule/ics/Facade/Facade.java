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
import ics.ICAStoreT4.OrderlineId;
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
	    
	    if (productEAO.findProductByProductIdForTheCreateMethod(productId) != null) {
	        throw new MyICAException("Failed to create Product! A product with ID " + productId + " already exists.");
	    }

	    Product newProduct = new Product();
	    newProduct.setProductId(productId);
	    newProduct.setProductName(productName);
	    newProduct.setPrice(price);

	    ProductCategory category;
	    try {
	        category = productCategoryEAO.findProductCategoryById(categoryId);
	    } catch (MyICAException e) {
	        throw new MyICAException("Failed to create Product! " + e.getMessage());
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
		
		public List<Object[]> findCustomerOrders(int customerId) throws MyICAException{
			try {
				return customerEAO.findCustomerOrders(customerId);
			} catch (MyICAException e) {
				// TODO Auto-generated catch block
				throw e;
			}
		}
		
		public List<Object[]> findAllCustomersOrdersAndTotalAmount() throws MyICAException {
			try {
				return customerEAO.findAllCustomersOrdersAndTotalAmount();
			} catch (MyICAException e) {
				// TODO Auto-generated catch block
				throw e;
			}
		}
			
		public Customer createCustomer(int customerId, String customerName, String userName, String address, int phoneNumber, String email ) throws MyICAException {
			
			if (customerEAO.findByCustomerIdForCreateMethod(customerId)  != null) {
			       throw new MyICAException("Failed to create customer! A customer with ID " + customerId + " already exists.");
			
			}
		
		Customer newCustomer = new Customer();
		newCustomer.setCustomerId(customerId);
		newCustomer.setName(customerName);
		newCustomer.setUserName(userName);
		newCustomer.setAddress(address);
		newCustomer.setPhoneNumber(phoneNumber);
		newCustomer.setEmail(email);
		
		 try {
		        return customerEAO.createCustomer(newCustomer);
		    } catch (Exception e) {
		        throw new MyICAException("Failed to create customer! " + e.getMessage());
		    }
		}
			
		public Customer updateCustomer(int customerId, String customerName, String userName, String address, int phoneNumber, String email) throws MyICAException  {
		    Customer existingCustomer = customerEAO.findByCustomerId(customerId);
		    if (existingCustomer == null) {
		        throw new MyICAException("Failed to update customer! A customer with ID " + customerId + " doesn't exist.");
		    }

		   
		    existingCustomer.setName(customerName);
		    existingCustomer.setUserName(userName);
		    existingCustomer.setAddress(address);
		    existingCustomer.setPhoneNumber(phoneNumber);
		    existingCustomer.setEmail(email);

		    try {
		        return customerEAO.updateCustomer(existingCustomer);
		    } catch (Exception e) {
		        throw new MyICAException("Failed to update customer! " + e.getMessage());
		    }
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
			
			 public List<Object[]> findSalesSummaryBySupermarketId(int supermarketId) throws MyICAException{
					try {
						return storeEAO.findSalesSummaryBySupermarketId(supermarketId);
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
			

			public List<Object[]> findOrderlineDetailsByOrderId (int orderId) throws MyICAException{
				try {
					return orderlineEAO.findOrderlineDetailsByOrderId(orderId);
				} catch (MyICAException e) {
					// TODO Auto-generated catch block
					throw e;
				}
			}
			
			public List<Object[]> findAllOrderlineDetails() throws MyICAException{
				try {
				return orderlineEAO.findAllOrderlineDetails();
			} catch (MyICAException e) {
				// TODO Auto-generated catch block
				throw e;
			}
			}
			

			
			public void deleteOrderline(Orderline orderline) throws MyICAException {
			
				try {
				orderlineEAO.deleteOrderline(orderline);
			} catch (MyICAException e) {
				// TODO Auto-generated catch block
				throw e;
			}
			}
			
			public void deleteOrderlineByOrderIdAndProductId(int orderId, int productId) throws MyICAException {
			    List<Orderline> orderlines = orderlineEAO.findOrderlineByOrderIdandProductId(orderId, productId);
			    if (!orderlines.isEmpty()) {
			        Orderline orderline = orderlines.get(0);
			        
			        orderlineEAO.deleteOrderlineByOrderIdAndProductId(orderline);
			    } else {
			        throw new MyICAException("Failed to delete the orderline! There is no orderline with Order ID: " + orderId + " and Product ID: " + productId);
			    }
			}


			public void updateOrderline(int orderId, int productId, int quantity) throws MyICAException {
			    try {
				List<Orderline> orderlines = orderlineEAO.findOrderlineByOrderIdandProductId(orderId, productId);
			    if (!orderlines.isEmpty()) {
			        Orderline orderline = orderlines.get(0);
			        orderline.setQuantity(quantity);
			        orderlineEAO.updateOrderline(orderline);
			    }    
			 } catch (Exception e) {
			        throw new MyICAException("Failed to create the order: " + e.getMessage());
			    }
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

			public Orderline createOrderline(int orderId, int productId, int orderLineNumber, int quantity) throws MyICAException {
			    try {
			        Order_ order = orderEAO.findOrderById(orderId);
			        Product product = productEAO.findProductByProductId(productId);
			        
			        List<Orderline> existingOrderlines = orderlineEAO.findOrderlineByOrderIdandProductId(orderId, productId);
			        if (!existingOrderlines.isEmpty()) {
			            throw new MyICAException("An orderline with the given order ID and product ID already exists");
			        }
			        
			        OrderlineId id = new OrderlineId();
			        id.setOrderId(orderId);
			        id.setProductId(productId);

			        Orderline newOrderline = new Orderline();
			        newOrderline.setId(id);
			        newOrderline.setOrderlineNumber(orderLineNumber);
			        newOrderline.setQuantity(quantity);

			        return orderlineEAO.createOrderline(newOrderline);
			    } catch (Exception e) {
			        throw new MyICAException("Failed to create the orderline: " + e.getMessage());
			    }
			}

			
			


			


			


		


	

}



