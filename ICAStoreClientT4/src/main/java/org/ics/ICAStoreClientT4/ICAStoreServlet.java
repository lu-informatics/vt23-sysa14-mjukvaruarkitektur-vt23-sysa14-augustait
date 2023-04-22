package org.ics.ICAStoreClientT4;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import ics.Facade.FacadeLocal;
import ics.ICAStoreT4.Customer;
import ics.ICAStoreT4.Order;
import ics.ICAStoreT4.Orderline;
import ics.ICAStoreT4.Product;
import ics.ICAStoreT4.ProductCategory;
import ics.ICAStoreT4.Store;
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
        
        Order order = new Order();
        order.setOrderId(6);
       // facade.deleteOrder(6);
         
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
         	 
         	// facade.createCustomer(customer);
         	 
         	 customer.setName("Ante testar update metoden");
         	// facade.updateCustomer(customer);
         	 
         //	 facade.deleteCustomer(18);
         	 
         	 customer = facade.findByCustomerId(18);
         	if (customer != null) {
            	out.println("<br>");
            	 out.println("Customer Name: "+customer.getName() + "<br>");
              	 out.println("Customer ID: "+customer.getCustomerId());
             	 out.println("<br>");
             	 
             List<Orderline>allOrderlines = facade.findAllOrderline();
             if (allOrderlines.isEmpty()) {
             	out.println("<p>No orderlines was founded!.</p>");
             	
           } else {
           	 out.println("<h4>All Orderlines in the database ICAStore:</h3>");
              out.print("<p>");
               for (Orderline orderlines : allOrderlines) {
            	    out.println("<li>Order ID: " + orderlines.getId().getOrderId() + ", Product ID: " +  orderlines.getId().getProductId() + "</li>");
               }
               out.println("</ul>");
           }
             	 //Order
             	 
//            List<Order>allOrders = facade.findAllOrders();
//            if(allOrders.isEmpty()) {
//            	out.println("<p>No products was founded!.</p>");
//            	
//            } else {
//            	 out.println("<h3>All Orders in the database ICAStore:</h3>");
//                 out.print("<p>");
//                 for (Order order : allOrders) {
//                   out.print("<p>" + "Order ID: " + order.getOrderId() + ", Order date: " +  order.getOrderDate() + "</p>") ;
//              
//            }
             	 
             	 
            //Store
             	 
            List<Store>allStores = facade.findAllStores();
            if (allStores.isEmpty()) {
            	out.println("<p>No products was founded!.</p>");
            } else {
            	 out.println("<h5>All Stores in the database ICAStore:</h3>");
                 out.print("<p>");
                 for (Store store : allStores) {
                   out.print("<p>" + "Supermarket ID: " + store.getSupermarketId() + ", Supermarket name: " +  store.getStoreName() + ""
                   		+ ", Address: " + store.getStoreAddress()  +  ", City: " + store.getCity() + ", Region: " + store.getRegionName()) ;
              }
            	
            }
             
           
             
         	 
         }
         }
    }
    }


         
         
         
    


    
    
    

    
