package ics.ICAStoreT4;


import java.util.List;

import org.ics.exceptions.MyICAException;

import jakarta.ejb.LocalBean;

@LocalBean
public interface ICAStoreEAOImplLocal {
	public Product createProduct(Product product);
	public Product updateProduct(Product product);
	public void deleteProduct(int id) throws MyICAException;
	public List<Product> findAllProducts() throws MyICAException;
	public Product findProductByProductId(int productId) throws MyICAException;
	public List<ProductCategory> findAllProductCategories() throws MyICAException;
	public ProductCategory findProductCategoryById(int id) throws MyICAException;
	public ProductCategory createProductCategory(ProductCategory category);
	public ProductCategory updateProductCategory(ProductCategory category);
	public void deleteProductCategory(int categoryId) throws MyICAException;

}
