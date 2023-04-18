package ics.ICAStoreT4;


import java.util.List;

import jakarta.ejb.LocalBean;

@LocalBean
public interface ICAStoreEAOImplLocal {
	public Product findProductById(int productId);
	public Product createProduct(Product product);
	public Product updateProduct(Product product);
	public void deleteProduct(int id);
	public List<Product> findAllProducts();
	public Product findProductByProductId(int productId);
	public List<ProductCategory> findAllProductCategories();
	public ProductCategory findProductCategoryById(int id);
	public ProductCategory createProductCategory(ProductCategory category);
	public ProductCategory updateProductCategory(ProductCategory category);
	public void deleteProductCategory(int categoryId);

}
