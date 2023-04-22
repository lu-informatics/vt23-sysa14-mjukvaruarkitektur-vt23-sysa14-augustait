package ics.Facade;




import java.util.List;

import ics.ICAStoreT4.Customer;
import ics.ICAStoreT4.CustomerEAOImplLocal;
import ics.ICAStoreT4.ICAStoreEAOImplLocal;
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
	/**
	* Default constructor.
	*/
	public Facade() {
	// TODO Auto-generated constructor stub
	}
	

	public Product updateProduct(Product product) {
		return productEAO.updateProduct(product);
	
	}
	
	public Product skapaProdukt(int productId, String productName, double price, int categoryId) {
	    Product newProduct = new Product();
	    newProduct.setProductId(productId);
	    newProduct.setProductName(productName);
	    newProduct.setPrice(price);
	    
	    // Find the ProductCategory entity that matches the categoryId
	    ProductCategory category = productCategoryEAO.findProductCategoryById(categoryId);
	    newProduct.setProductCategory(category);
	    
	    return productEAO.createProduct(newProduct);
	}


	
	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		
	}


	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productEAO.findAllProducts();
	}


	
	public ProductCategory createProductCategory(ProductCategory productCategory) {
		return productCategoryEAO.createProductCategory(productCategory);
		}



	public Product createProduct(Product product) { //TA BORT!
		// TODO Auto-generated method stub
		return productEAO.createProduct(product);
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
				// TODO Auto-generated method stub
				return storeEAO.findAllStores();
			}


		


	

}



