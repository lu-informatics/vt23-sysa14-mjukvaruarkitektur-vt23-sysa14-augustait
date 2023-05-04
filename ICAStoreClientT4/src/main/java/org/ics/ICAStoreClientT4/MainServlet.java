package org.ics.ICAStoreClientT4;

import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.ics.exceptions.MyICAException;

import ics.Facade.Facade;
import ics.Facade.FacadeLocal;
import ics.ICAStoreT4.CustomerEAOImplLocal;
import ics.ICAStoreT4.OrderEAOImpl;
import ics.ICAStoreT4.Order_;
import ics.ICAStoreT4.Orderline;

import java.util.List;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    FacadeLocal facade = new Facade();
    @EJB
    private CustomerEAOImplLocal customerEAO;
    OrderEAOImpl orderEAO = new OrderEAOImpl();
    
    

    public MainServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            boolean connectionTestResult = orderEAO.testConnection();
            System.out.println("Database connection test result: " + connectionTestResult);

            List<Order_> orders = facade.findAllOrders();
            request.setAttribute("orders", orders); // Add this line

            RequestDispatcher dispatcher = request.getRequestDispatcher("/Overview.jsp");
            dispatcher.forward(request, response);
        } catch (MyICAException e) {
            // Handle the exception and display an error message
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().append("Error: " + e.getMessage());
        }
    }

        
        


    




    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     // CREATE ORDER
    	
    	try {
        	
        	
            String orderIdStr = request.getParameter("orderId");
            String orderDate = request.getParameter("orderDate");
            String paymentMethod = request.getParameter("paymentMethod");
            String customerIdStr = request.getParameter("customerId");
            String supermarketIdStr = request.getParameter("supermarketId");

            System.out.println("Received form values:");
            System.out.println("orderIdStr: " + orderIdStr);
            System.out.println("orderDate: " + orderDate);
            System.out.println("paymentMethod: " + paymentMethod);
            System.out.println("customerIdStr: " + customerIdStr);
            System.out.println("supermarketIdStr: " + supermarketIdStr);

            if (orderIdStr == null || customerIdStr == null || supermarketIdStr == null) {
                throw new NumberFormatException("Cannot parse null string");
            }
            int orderId = Integer.parseInt(orderIdStr);
            int customerId = Integer.parseInt(customerIdStr);
            int supermarketId = Integer.parseInt(supermarketIdStr);

            Order_ order = facade.createOrder(orderId, orderDate, paymentMethod, customerId, supermarketId);

            System.out.println("Order created:");
            System.out.println("orderId: " + order.getOrderId());
            System.out.println("orderDate: " + order.getOrderDate());
            System.out.println("paymentMethod: " + order.getPaymentMethod());

            System.out.println("Context path: " + request.getContextPath());

            // Redirect to success page or display success message
            response.getWriter().append("Order created successfully.");
        } catch (NumberFormatException e) {
            // Handle parsing errors for integer values
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().append("Error: Invalid input data.");
            e.printStackTrace();
        } catch (MyICAException e) {
            // Handle the exception and display an error message
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().append("Error: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            // Handle any other unexpected exceptions
}
    	
//    	// CREATE ORDERLINE
//    	 try {
//    	        String order = request.getParameter("order");
//    	        String product = request.getParameter("product");
//
//    	        if (order == null || product == null) {
//    	            throw new IllegalArgumentException("Invalid order or product parameters");
//    	        }
//
//    	        int orderId = Integer.parseInt(order);
//    	        int productId = Integer.parseInt(product);
//
//    	        // Call the createOrderLine method in the Facade to create the order line
//    	        Orderline orderLine = facade.createOrderLine(orderId, productId, orderLineNumber, quantity);
//
//    	        // Handle the success scenario
//    	        response.setStatus(HttpServletResponse.SC_OK);
//    	        response.getWriter().write("Order line created successfully.");
//    	    } catch (NumberFormatException e) {
//    	        // Handle parsing errors for integer values
//    	        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//    	        response.getWriter().write("Error: Invalid input data.");
//    	        e.printStackTrace();
//    	    } catch (MyICAException e) {
//    	        // Handle the exception and display an error message
//    	        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//    	        response.getWriter().write("Error: " + e.getMessage());
//    	        e.printStackTrace();
//    	    } catch (Exception e) {
//    	        // Handle any other unexpected exceptions
//    	        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//    	        response.getWriter().write("Error: An unexpected error occurred.");
//    	        e.printStackTrace();
//    	    }
//    	}
    	
    }
}