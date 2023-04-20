package org.ics.ICAStoreClientT4;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import ics.Facade.FacadeLocal;
import ics.ICAStoreT4.Customer;
import ics.ICAStoreT4.Product;
import ics.ICAStoreT4.ProductCategory;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ICAStoreServlet
 */
public class ICAStoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	FacadeLocal facade;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ICAStoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html><html><head>");
        out.println("<title>ICAStore</title>");
        out.println("<meta charset=\"ISO-8859-1\">");
        out.println("</head><body>");
        out.println("<h2>ICAStore</h2>");

        // Hämta alla produkter från databasen
//        List<Product> allProducts = facade.
//        if (allProducts.isEmpty()) {
//            out.println("<p>No products was founded!.</p>");
//        } else {
//            // Skriv ut rubrik för produkt-ID
//            out.println("<h3>All Products in the database ICAStore:</h3>");
//            out.print("<p>");
//            for (Product product : allProducts) {
//                out.print("<p>" + "Product ID: " + product.getProductId() + ", Product name: " +  product.getProductName() + ""
//                		+ ", Product Price: " + product.getPrice() + "kr" + ", Category ID: " + product.getProductCategory());
//            }
//            out.print("<h4>**** Product create****</h4>");
            
//         ProductCategory productCategory = new ProductCategory();
//        // productCategory.setCategoryId(591);
//         productCategory.setCategoryName("Antonio test");
//         Product product = new Product();
//         product.setProductId(122133);
//         product.setPrice(2.0);
//         product.setProductName("Antonio");
//         product.s
//       
       
         
       
//         try {
//        	 // ProductCategory createdProductCategory = facade.createProductCategory(productCategory);
//        	 // out.print("<p>" + createdProductCategory.getCategoryId());
//        	  facade.skapaProdukt(323233423, "LEGACY_DO_HEAD", 400.0, 1);
//        	  
//        	} catch (Exception e) {
//        	  if (e.getCause() instanceof SQLIntegrityConstraintViolationException) {
//        	    out.print("<p>Product ID already exists. Please choose a different ID.</p>");
//        	  } else {
//        	    out.print("<p>Error creating product.</p>");
//        	  }
//        	}
         
         ProductCategory category = new ProductCategory();
         category.setCategoryId(18);
         category.setCategoryName("Digitalisering");
        // facade.createProductCategory(category);
         
         category.setCategoryName("Uppdatering av kategori namnet");
        // facade.updateProductCategory(category);
         
      //  facade.deleteProductCategory(18);
         
         out.print("Test fungerade");
         
         category  =  facade.findByCategoryId(18);
         if (category != null) {
        	out.println("<br>");
        	 out.println("Category Name: "+category.getCategoryName() + "<br>");
          	 out.println("Category ID: "+category.getCategoryId());
         	 out.println("<br>");
         	 
         	 
         	 Customer customer = new Customer();
         	 customer.setName("Antonio testar");
         	 customer.setEmail("ante@gmail.com");
         	 customer.setPhoneNumber(123);
         	 customer.setCustomerId(18);
         	 customer.setUserName("@ante");
         	 
         	 //facade.createCustomer(customer);
         	 
         	 customer.setName("Ante testar update metoden");
         	// facade.updateCustomer(customer);
         	 
         	 facade.deleteCustomer(18);
         	 
         	 customer = facade.findByCustomerId(18);
         	if (customer != null) {
            	out.println("<br>");
            	 out.println("Customer Name: "+customer.getName() + "<br>");
              	 out.println("Customer ID: "+customer.getCustomerId());
             	 out.println("<br>");
         	 
         }
         
         
         
    }
}
}
    
    
    

    
