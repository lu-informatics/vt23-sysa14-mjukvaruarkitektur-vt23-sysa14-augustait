package org.ics.ejb.restserver;

import jakarta.ejb.EJB;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObjectBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.ics.exceptions.MyICAException;

import ics.Facade.FacadeLocal;
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
		if(pathInfo == null || pathInfo.equals("/")){
		System.out.println("Alla");
		System.out.println(pathInfo);
		List<ics.ICAStoreT4.Product> allMovies = facade.findAllProducts();
		sendAsJson(response, allMovies);
		return;
		}
		String[] splits = pathInfo.split("/");
		if(splits.length != 2) {
		System.out.println("Alla2");
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		return;
		}
		String id = splits[1];
		Product movie;
		
			movie = facade.findByProductId(Integer.parseInt(id));
			sendAsJson(response, movie);

		}  catch (MyICAException e) {
			// TODO Auto-generated catch block
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
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
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
		Product movie = facade.findByProductId(Integer.parseInt(id));
		if (movie != null) {
		
			facade.deleteProduct(Integer.parseInt(id));
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
			out.print("\"" +movie.getPrice()+"\"}");
			} else {
			out.print("{ }");
			}
			out.flush();
			}
	
	
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


}
