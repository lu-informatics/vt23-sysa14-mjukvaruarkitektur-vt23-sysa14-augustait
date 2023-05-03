package org.ics.ICAStoreClientT4;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.ics.exceptions.MyICAException;

import ics.Facade.Facade;
import ics.Facade.FacadeLocal;
import ics.ICAStoreT4.Order_;

/**
 * Servlet implementation class MainServlet
 */
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	FacadeLocal facade = new Facade();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		try {
			facade.createOrder(24, "2000-00-00", "hello", 1, 2);
		} catch (MyICAException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	
	
	
	
	
	
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	        response.getWriter().append("Error: An unexpected error occurred.");
	        e.printStackTrace();
	    }
	}




}
