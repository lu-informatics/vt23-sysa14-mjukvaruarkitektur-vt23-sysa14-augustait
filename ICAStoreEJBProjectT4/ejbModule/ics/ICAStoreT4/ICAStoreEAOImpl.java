package ics.ICAStoreT4;

import java.util.List;

import org.ics.exceptions.MyICAException;

import jakarta.ejb.Local;
import jakarta.ejb.Stateful;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * Session Bean implementation class ICAStoreEAOImpl
 */
@Stateful
@Local
public class ICAStoreEAOImpl implements ICAStoreEAOImplLocal {

@PersistenceContext(unitName = "LabEJBSql")
private EntityManager em;


public Product createProduct(Product product) {
em.persist(product);
return product;
}

public Product updateProduct(Product product) {
em.merge(product);
return product;
}

public void deleteProduct(int id) throws MyICAException  {
Product p = em.find(Product.class, id);
if (p != null) {
em.remove(p);

} else {
	throw new MyICAException("Failed to delete the product! There is no product with Product ID: " + id);
			}
	
}
	


public List<Product> findAllProducts() {
return em.createNamedQuery("Product.findAll", Product.class).getResultList();
}

public Product findProductByProductId(int productId) {
return em.createNamedQuery("Product.findByProductId", Product.class)
.setParameter("id", productId)
.getSingleResult();
}

public List<ProductCategory> findAllProductCategories() {
	return em.createNamedQuery("ProductCategory.findAll", ProductCategory.class)
	         .getResultList();
}

public ProductCategory findProductCategoryById(int id) {
	return em.createNamedQuery("ProductCategory.findByCategoryId", ProductCategory.class)
	         .setParameter("categoryId", id)
	         .getSingleResult();
}

public ProductCategory createProductCategory(ProductCategory category) {
    em.persist(category);
    return category;
}

public ProductCategory updateProductCategory(ProductCategory category) {
    em.merge(category);
    return category;
}

public void deleteProductCategory(int categoryId) {
    ProductCategory category = em.find(ProductCategory.class, categoryId);
    if (category != null) {
        em.remove(category);
    }


} 

}

	


