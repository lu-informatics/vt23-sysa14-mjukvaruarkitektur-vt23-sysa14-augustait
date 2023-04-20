package ics.Facade;




import java.util.List;

import ics.ICAStoreT4.ICAStoreEAOImplLocal;
import ics.ICAStoreT4.Product;
import ics.ICAStoreT4.ProductCategory;
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


	

}



