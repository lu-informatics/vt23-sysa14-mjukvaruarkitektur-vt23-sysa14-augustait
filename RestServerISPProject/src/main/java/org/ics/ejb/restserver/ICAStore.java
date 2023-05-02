package org.ics.ejb.restserver;

import jakarta.ejb.EJB;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.json.JsonReader;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.ics.exceptions.MyICAException;

import ics.Facade.FacadeLocal;
import ics.ICAStoreT4.Customer;
import ics.ICAStoreT4.Order_;
import ics.ICAStoreT4.Product;

/**
 * Servlet implementation class ICAStore
 */
@WebServlet("/ICAStore/*")
public class ICAStore extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	FacadeLocal facade;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ICAStore() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 try {
	            String pathInfo = request.getPathInfo();
	            if (pathInfo == null || pathInfo.equals("/")) {
	                String requestURL = request.getRequestURL().toString();
	                if (requestURL.endsWith("/products")) {
	                    List<Product> allProducts = facade.findAllProducts();
	                    sendAsJson(response, allProducts);
	                    return;
	                }
	                if (requestURL.endsWith("/customers")) {
	                    List<Customer> allCustomers = facade.findAllCustomer();
	                    sendAsJsonCustomers(response, allCustomers);
	                    return;
	                }
	                
	            } else {
	                String[] splits = pathInfo.split("/");
	                if (splits.length != 2) {
	                    response.sendError(HttpServletResponse.SC_BAD_REQUEST);
	                    return;
	                }
	                String id = splits[1];
	                if (pathInfo.startsWith("/products/")) {
	                    Product product = facade.findByProductId(Integer.parseInt(id));
	                    sendAsJson(response, product);
	                } else if (pathInfo.startsWith("/orders/")) {
	                    Order_ order = facade.findOrderById(Integer.parseInt(id));
	                    sendAsJson(response, order);
	                }
	            }
	            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
	        } catch (MyICAException e) {
	            e.printStackTrace();
	        }
	    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */

		// TODO Auto-generated method stub
	

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		
			//Delete Order
			String pathInfo = request.getPathInfo();
		if(pathInfo == null || pathInfo.equals("/")){
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		return;
		}
		String[] splits = pathInfo.split("/");
		if(splits.length != 2) {
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		return;
		}
		String id = splits[1];
		Order_ movie = facade.findOrderById(Integer.parseInt(id));
		if (movie != null) {
		
			facade.deleteOrder(Integer.parseInt(id));
			sendAsJson(response, movie);
		}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MyICAException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void sendAsJson(HttpServletResponse response, Product movie)
			throws IOException {
		PrintWriter out = response.getWriter();
	    response.setContentType("application/json");
	    if (movie != null) {
	        out.print("{\"title\":");
	        out.print("\"" + movie.getProductName() + "\"");
	        out.print(",\"id\":");
	        out.print("\"" +movie.getProductId()+"\"");
	        out.print(",\"price\":");
	        out.print("\"" +movie.getPrice()+"\"");
	        out.print(",\"ProductCategory\":");
	        out.print("\"" +movie.getProductCategory()+"\"}");
	    } else {
	        out.print("{ }");
	    }
	    out.flush();
	}
	
	
	
	//JSON ORDER
	private void sendAsJson(HttpServletResponse response, Order_ movie)
			throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		if (movie != null) {
		    out.print("{\"ID\":\"" + movie.getOrderId() + "\",");
		    out.print("\"OrderDate\":\"" + movie.getOrderDate() + "\",");
		    out.print("\"SupermarketID\":\"" + movie.getStore() + "\",");
		    out.print("\"CustomerID\":\"" + movie.getCustomer() + "\",");
		    out.print("\"PaymentMethod Number\":\"" + movie.getPaymentMethod() + "\",");
		} else {
		    out.print("{ }");
		}
		out.flush();
	}
	
	//JSON ALL PRODUCTS
	private void sendAsJson(HttpServletResponse response, List< Product> movies)
			throws IOException {
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			if (movies != null) {
			JsonArrayBuilder array = Json.createArrayBuilder();
			for (ics.ICAStoreT4.Product m : movies) {
			JsonObjectBuilder o = Json.createObjectBuilder();
			o.add("id", String.valueOf(m.getProductId()));
			o.add("title", m.getProductName());
			o.add("price", String.valueOf(m.getPrice()));
			array.add(o);
			}
			JsonArray jsonArray = array.build();
			System.out.println("Movie Rest: "+jsonArray);
			out.print(jsonArray);
			} else {
			out.print("[]");
			}
			out.flush();
			}
	
	//JSON ALL CUSTOMERS
		private void sendAsJsonCustomers(HttpServletResponse response, List<Customer> customer)
				throws IOException {
				PrintWriter out = response.getWriter();
				response.setContentType("application/json");
				if (customer != null) {
				JsonArrayBuilder array = Json.createArrayBuilder();
				for (ics.ICAStoreT4.Customer m : customer) {
				JsonObjectBuilder o = Json.createObjectBuilder();
				o.add("id", String.valueOf(m.getCustomerId()));
				o.add("name", m.getName());
				o.add("UserName", m.getUserName());
				o.add("Email", m.getEmail());
				o.add("number", String.valueOf(m.getPhoneNumber()));
				o.add("Address", m.getAddress());

				array.add(o);
				}
				JsonArray jsonArray = array.build();
				System.out.println("Movie Rest: "+jsonArray);
				out.print(jsonArray);
				} else {
				out.print("[]");
				}
				out.flush();
				}
		
		private Customer parseJson(BufferedReader br) {
			//javax.json-1.0.4.jar
			JsonReader jsonReader = null;
			JsonObject jsonRoot = null;
			jsonReader = Json.createReader(br);
			jsonRoot = jsonReader.readObject();
			System.out.println("JsonRoot: "+jsonRoot);
			Customer movie = new Customer();
			movie.setCustomerId(Integer.parseInt(jsonRoot.getString("id")));
			movie.setUserName(jsonRoot.getString("userName"));
			movie.setName(jsonRoot.getString("Name"));
			movie.setEmail(jsonRoot.getString("Email"));
			movie.setAddress(jsonRoot.getString("Address"));
			movie.setPhoneNumber(Integer.parseInt(jsonRoot.getString("phoneNumber")));
			return movie;
			}


}
