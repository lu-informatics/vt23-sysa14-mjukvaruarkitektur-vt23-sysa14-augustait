package org.ics.ICAStoreClientT4;

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
	    // Get the form data
	    int orderId = Integer.parseInt(request.getParameter("order-id"));
	    String orderDate = request.getParameter("order-date");
	    String paymentMethod = request.getParameter("payment-method");
	    int customerId = Integer.parseInt(request.getParameter("customer-id"));
	    int supermarketId = Integer.parseInt(request.getParameter("supermarket-id"));

	    // Create a new order using the FacadeLocal instance
	    try {
	        Order_ order = facade.createOrder(orderId, orderDate, paymentMethod, customerId, supermarketId);
	        request.setAttribute("order", order);
	        request.getRequestDispatcher("OrderConfirmation.jsp").forward(request, response);
	    } catch (MyICAException e) {
	        request.setAttribute("errorMessage", e.getMessage());
	        request.getRequestDispatcher("Home.jsp").forward(request, response);
	    }
	}



}
