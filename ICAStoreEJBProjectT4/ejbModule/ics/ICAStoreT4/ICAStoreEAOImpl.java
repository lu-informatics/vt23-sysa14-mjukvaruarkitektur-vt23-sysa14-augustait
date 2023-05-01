package ics.ICAStoreT4;

import java.util.List; 

import org.ics.exceptions.MyICAException;

import jakarta.ejb.Local;
import jakarta.ejb.Stateful;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
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
	


public List<Product> findAllProducts() throws MyICAException {
	try  {
return em.createNamedQuery("Product.findAll", Product.class).getResultList();

} catch (Exception e) {
    throw new MyICAException("Failed to retrieve the list of products: " + e.getMessage());
}
}

//Denna används när vi skapar nya Orderlines

public Product findProductByProductId(int productId) throws MyICAException { 
    try {
        return em.createNamedQuery("Product.findByProductId", Product.class)
                .setParameter("id", productId)
                .getSingleResult();
    } catch (NoResultException e) {
        throw new MyICAException("Failed to retrieve the Product! There is no Product with the Product ID: " + productId);
    }
}

// Denna används när vi skapar nya Products eller uppdaterar befintliga

public Product findProductByProductIdForTheCreateMethod(int productId) {
    try {
        return em.createNamedQuery("Product.findByProductId", Product.class)
                 .setParameter("id", productId)
                 .getSingleResult();
    } catch (NoResultException ex) {
        
        return null;
    }
}

public List<ProductCategory> findAllProductCategories() throws MyICAException {
	try {
	return em.createNamedQuery("ProductCategory.findAll", ProductCategory.class)
	         .getResultList();
	} catch (Exception e) {
	    throw new MyICAException("Failed to retrieve the list of Product Categories: " + e.getMessage());
	}
	}



public ProductCategory findProductCategoryById(int id) throws MyICAException {
    try {
        ProductCategory category = em.createNamedQuery("ProductCategory.findByCategoryId", ProductCategory.class)
                .setParameter("categoryId", id)
                .getSingleResult();
        return category;
    } catch (NoResultException e) {
        throw new MyICAException("Failed to retrieve the Product Category! There is no category with the ID: " + id);
    }
}

public ProductCategory createProductCategory(ProductCategory category) {
    em.persist(category);
    return category;
}

public ProductCategory updateProductCategory(ProductCategory category) {
    em.merge(category);
    return category;
}

public void deleteProductCategory(int categoryId) throws MyICAException {
    ProductCategory category = em.find(ProductCategory.class, categoryId);
    if (category != null) {
        em.remove(category);
    
} else {
	throw new MyICAException("Failed to delete the Product Category! There is no Product Category with Category ID: " + categoryId);
			}
	
}


} 



	


