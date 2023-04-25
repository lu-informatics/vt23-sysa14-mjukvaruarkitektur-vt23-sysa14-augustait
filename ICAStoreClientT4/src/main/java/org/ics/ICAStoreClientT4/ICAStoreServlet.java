package org.ics.ICAStoreClientT4;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.ics.exceptions.MyICAException;

import ics.Facade.FacadeLocal;
import ics.ICAStoreT4.Customer;

import ics.ICAStoreT4.Order_;
import ics.ICAStoreT4.Orderline;
import ics.ICAStoreT4.OrderlineId;
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
        
        Order_ order = new Order_();
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
         
         try {
			category  =  facade.findByCategoryId(1);
		} catch (MyICAException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
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
         	 
         	 try {
				customer = facade.findByCustomerId(18);
			} catch (MyICAException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
         	if (customer != null) {
            	out.println("<br>");
            	 out.println("Customer Name: "+customer.getName() + "<br>");
              	 out.println("Customer ID: "+customer.getCustomerId());
             	 out.println("<br>");
             
             	 Product product = new Product();
             	 product.setProductId(1);
             	 product.setProductId(345);
             	 
             	 ProductCategory pc = new ProductCategory();
             	 pc.setCategoryId(345);
             	 
             	 try {
					//facade.deleteProduct(345);
				//	out.println("<br>");
					// out.println("The Product with the Product ID: " + product.getProductId() + " was deleted successfully! ");
	             	//  out.println("<br>");
	             	 
	             	 
//	               	facade.deleteProductCategory(657);
//	             	out.println("<br>");
//					out.println("The Product Category with the Category ID: " + pc.getCategoryId() + " was deleted successfully! ");
//	             	out.println("<br>");
	             	
//	             	facade.deleteCustomer(198);
//	             	facade.deleteOrder(3242);
//	             	facade.deleteStore(2324);
	             	
                     facade.findByStoreId(1);
             		 
             		 facade.findByCustomerId(1);
             		 
             		 facade.findByProductId(1);
             		 out.println(product.getProductId());
            		// facade.findOrderById(2390);
             		// facade.findByCategoryId(2390);
             		List<Orderline> orderlines = facade.findOrderlineByOrderId(9889);
					
				} catch (MyICAException e) {
					// TODO Auto-generated catch block
					out.println("<br>");
					out.println("<span style='color:red;font-size:larger;'>" + e.getMessage() + "</span>");
					out.println("<br>");
				}
             	
             	 
             	Orderline orderline = new Orderline();
             	OrderlineId id = new OrderlineId();
             	id.setOrderId(1); 
             	id.setProductId(1);
             	orderline.setId(id); 
             	orderline.setOrderlineNumber(1); 
             	orderline.setQuantity(2);
            // facade.createOrderline(orderline);
            
             
             	 
             List<Orderline>allOrderlines = facade.findAllOrderline();
             if (allOrderlines.isEmpty()) {
             	out.println("<p>No orderlines was founded!.</p>");
             	
           } else {
           	 out.println("<h4>All Orderlines in the database ICAStore:</h3>");
              out.print("<p>");
               for (Orderline orderlines : allOrderlines) {
            	    out.println("<li> Orderline number: " + orderlines.getOrderlineNumber() + ", Order ID: " + orderlines.getId().getOrderId() + ", Product ID: " +  orderlines.getId().getProductId() + ", Quantity: " + orderlines.getQuantity() + "</li>");
               }
               out.println("</ul>");
           }
             	 //Order_
             
             
           Order_ orders = new Order_();
           
           try {
			facade.createOrder(345, "2002-02-04", "Klarna", 938, 1);
		} catch (MyICAException e) {
			// TODO Auto-generated catch block
			out.println("<br>");
			out.println("<span style='color:red;font-size:larger;'>" + e.getMessage() + "</span>");
			out.println("<br>");
		}
		}
           
           
         
           
          List<Order_>allOrders = facade.findAllOrders();
           if(allOrders.isEmpty()) {
          	out.println("<p>No products was founded!.</p>");
           	
           } else {
           	 out.println("<h3>All Orders in the database ICAStore:</h3>");
               out.print("<p>");
                for (Order_ order_: allOrders) {
                 out.print("<p>" + "Order ID: " + order_.getOrderId() + ", Order date: " +  order_.getOrderDate() + "</p>") ;
            
           }
             	 
             	 
            //Store
                
                Store store = new Store();
                store.setSupermarketId(85);
                store.setCity("Landskrona");
                store.setRegionName("Skåne");
                store.setStoreAddress("Hermelinen");
                store.setStoreName("ICA MAXI Landskrona");
                
                //facade.createStore(store);
                
             
                
                
               // facade.deleteStore(85);
             	 
            List<Store>allStores = facade.findAllStores();
            if (allStores.isEmpty()) {
            	out.println("<p>No stores was founded!.</p>");
            } else {
            	 out.println("<h5>All Stores in the database ICAStore:</h3>");
                 out.print("<p>");
                 for (Store stores : allStores) {
                   out.print("<p>" + "Supermarket ID: " + stores.getSupermarketId() + ", Supermarket name: " +  stores.getStoreName() + ""
                   		+ ", Address: " + stores.getStoreAddress()  +  ", City: " + stores.getCity() + ", Region: " + stores.getRegionName()) ;
              }
            	
            }
            
             
           
             
         	 
         }
         }
    }
    }

    


         
         
         
    


    
    
    

    
