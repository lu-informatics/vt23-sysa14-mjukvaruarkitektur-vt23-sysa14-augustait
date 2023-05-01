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
             		 
                     
                   //  facade.createCustomer(89, "Test", "Test", "Test", 1, "Test");
                     facade.updateCustomer(1, "Test", "Testtttt", "Test", 1234, "Test");
             		 facade.findByCustomerId(1);
             		 
             		 facade.findByProductId(1);
             		 out.println(product.getProductId());
            		// facade.findOrderById(2390);
             		// facade.findByCategoryId(2390);
             		//List<Orderline> orderlines = facade.findOrderlineByOrderId(9889);
					
             		List<Customer>customerAll = facade.findAllCustomer();
             		for (Customer customers : customerAll) {
             	        out.println("Customer ID: " + customers.getCustomerId());
             	        out.println("Name: " + customers.getName());
             	        out.println("Email: " + customers.getEmail());
             	        out.println("<br>");
             		
             		}
				} catch (MyICAException e) {
					// TODO Auto-generated catch block
					out.println("<br>");
					out.println("<span style='color:red;font-size:larger;'>" + e.getMessage() + "</span>");
					out.println("<br>");
				}
             	
             	 
             	Orderline orderline = new Orderline();
             	OrderlineId id = new OrderlineId();
             	id.setOrderId(9283); 
             	id.setProductId(1);
             	orderline.setId(id); 
             	orderline.setOrderlineNumber(1); 
             	orderline.setQuantity(2);
                try {
					//facade.createOrderline(10, 3, 1, 2);
                	facade.deleteOrderlineByOrderIdAndProductId(1, 2);
				} catch (MyICAException e1) {
					// TODO Auto-generated catch block
					out.println("<br>");
					out.println("<span style='color:blue;font-size:larger;'>" + e1.getMessage() + "</span>");
					out.println("<br>");
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
           
        
 
           
           List<Object[]> orderlines;
           try {
               orderlines = facade.findOrderlineDetailsByOrderId(1);
               out.println("<table>");
               out.println("<tr><th>Customer Name</th><th>Customer ID</th><th> Orderline Number</th><th>Order ID</th><th>Product ID</th><th>Product Name</th><th>Price</th><th>Order Date</th><th>Store Name</th><th>Supermarket ID</th><th>Quantity</th><th>Payment Method</th><th>Line Amount</th><th>Order Amount</th></tr>");
               for (Object[] details : orderlines) {
                   out.println("<tr>");
                   out.println("<td>" + details[0] + "</td>");
                   out.println("<td>" + details[1] + "</td>");
                   out.println("<td>" + details[2] + "</td>");
                   out.println("<td>" + details[3] + "</td>");
                   out.println("<td>" + details[4] + "</td>");
                   out.println("<td>" + details[5] + "</td>");
                   out.println("<td>" + details[6] + " kr" + "</td>");
                   out.println("<td>" + details[7] + "</td>");
                   out.println("<td>" + details[8] + "</td>");
                   out.println("<td>" + details[9] + "</td>");
                   
                   out.println("<td>" + details[10]+ "</td>");
                   out.println("<td>" + details[11]+ "</td>");
                   out.println("<td>" + details[12]+ "</td>");
                   out.println("<td>" + details[13]+ "</td>");
                   out.println("</tr>");
               out.println("</table>");
               }
           } catch (MyICAException e) {
               e.printStackTrace();
           }
           
           
           List<Object[]> allOrderlines;
           try {
               allOrderlines = facade.findAllOrderlineDetails();
               out.println("<table>");
               out.println("<tr><th>Customer Name</th><th>Customer ID</th><th> Orderline Number</th><th>Order ID</th><th>Product ID</th><th>Product Name</th><th>Price</th><th>Order Date</th><th>Store Name</th><th>Supermarket ID</th><th>Quantity</th><th>Payment Method</th><th>Line Amount</th><th>Order Amount</th></tr>");
               for (Object[] details : allOrderlines) {
                   out.println("<tr>");
                   out.println("<td>" + details[0] + "</td>");
                   out.println("<td>" + details[1] + "</td>");
                   out.println("<td>" + details[2] + "</td>");
                   out.println("<td>" + details[3] + "</td>");
                   out.println("<td>" + details[4] + "</td>");
                   out.println("<td>" + details[5] + "</td>");
                   out.println("<td>" + details[6] + " kr" + "</td>");
                   out.println("<td>" + details[7] + "</td>");
                   out.println("<td>" + details[8] + "</td>");
                   out.println("<td>" + details[9] + "</td>");
                   
                   out.println("<td>" + details[10]+ "</td>");
                   out.println("<td>" + details[11]+ "</td>");
                   out.println("<td>" + details[12]+ "</td>");
                   out.println("<td>" + details[13]+ "</td>");
                   out.println("</tr>");
               }
               out.println("</table>");
           } catch (MyICAException e) {
               e.printStackTrace();
           }
           
           
       
         
           
           List<Object[]> customersOrders;
          
           try {
               customersOrders = facade.findCustomerOrders(1);
               out.println("<table>");
               out.println("<tr><th>Customer ID</th><th>Customer name</th><th>Address</th><th>Username</th><th>Total orders</th><th>Total price </th></tr>");
               for (Object[] details : customersOrders) {
                   out.println("<tr>");
                   out.println("<td>" + details[0] + "</td>");
                   out.println("<td>" + details[1] + "</td>");
                   out.println("<td>" + details[2] + "</td>");
                   out.println("<td>" + details[3] + "</td>");
                   out.println("<td>" + details[4] + "</td>");
                   out.println("<td>" + details[5] + "</td>");
                   
                   
                   out.println("</tr>");
               }
               out.println("</table>");
           } catch (MyICAException e) {
               out.println(e.getMessage());
           }
          
           List<Object[]> customersOrdersForAll;
           
           try {
        	   customersOrdersForAll = facade.findAllCustomersOrdersAndTotalAmount();
        	   out.println("<table>");
        	   out.println("<tr><th>Customer ID</th><th>Customer name</th><th>Address</th><th>Username</th><th>Total orders</th><th>Total price </th></tr>");
        	   for (Object[] details : customersOrdersForAll) {
        	   out.println("<tr>");
        	   out.println("<td>" + details[0] + "</td>");
        	   out.println("<td>" + details[1] + "</td>");
        	   out.println("<td>" + details[2] + "</td>");
        	   out.println("<td>" + details[3] + "</td>");
        	   out.println("<td>" + details[4] + "</td>");
        	   out.println("<td>" + details[5] + "</td>");
        	   out.println("</tr>");
        	   }
        	   out.println("</table>");
        	   } catch (MyICAException e) {
        	   out.println(e.getMessage());
        	   }
           
           List<Object[]> stores;
           try {
               stores = facade.findSalesSummaryBySupermarketId(1);
               out.println("<table>");
               out.println("<tr><th>Store name</th><th>Store ID</th><th>Address</th><th>City</th><th>Region</th><th>Total customers</th><th>Total orders</th><th>Total incomes of sales</th><th></tr>");
               for (Object[] details : stores) {
                   out.println("<tr>");
                   out.println("<td>" + details[0] + "</td>");
                   out.println("<td>" + details[1] + "</td>");
                   out.println("<td>" + details[2] + "</td>");
                   out.println("<td>" + details[3] + "</td>");
                   out.println("<td>" + details[4] + "</td>");
                   out.println("<td>" + details[5] + "</td>");
                   out.println("<td>" + details[6] + "</td>");
                   out.println("<td>" + details[7] + "</td>");
                   
                   out.println("</tr>");
               }
               out.println("</table>");
           } catch (MyICAException e) {
               e.printStackTrace();
           }
           
         	}
         }
    }
}
           
           
         
 
             	 
         
                
              
                
             
                
                
  
               
             
         	 
         
         
    
    
    


         
         
         
    


    
    
    

    
