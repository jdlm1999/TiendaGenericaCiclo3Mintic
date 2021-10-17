package co.edu.unbosque.ciclo3.Venta;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import co.edu.unbosque.ciclo3.Cliente.Cliente;
import co.edu.unbosque.ciclo3.Cliente.ClienteJSON;
import co.edu.unbosque.ciclo3.Producto.ProductJSON;

/**
 * Servlet implementation class VentaServlet
 */
@WebServlet("/VentaServlet/*")
public class VentaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VentaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getPathInfo();
		
		String button = request.getParameter("buscarCod1");
		
		System.out.println("Action: " + action);
		
		try {
			switch (action) {
			case "/venta":
				showNewForm(request, response);
				break;
			case "/searchClient":
				buscarCliente(request, response);
				break;
			case "/searchProduct":
				searchProduct1(request, response);
				break;
			case "/searchProduct2":
				searchProduct2(request, response);
				break;
			case "/searchProduct3":
				searchProduct3(request, response);
				break;
//			case "/busqueda":
//				getOne(request, response);
//				break;
//			default:
//				listUser(request, response);
//				break;
			}
		} catch (Exception e) {
			System.err.println("Error: path");
			System.err.println(e.getMessage());

			RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
			dispatcher.forward(request, response);
		}
		
		String consultarCedula = request.getParameter("BuscarCliente");
		System.out.println(consultarCedula);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/Venta/venta-consult.jsp");
		dispatcher.forward(request, response);
	}
	
	private void buscarCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			PrintWriter writter = response.getWriter();
			Long cedulaBuscar = Long.parseLong(request.getParameter("cedula"));
			JSONObject client = ClienteJSON.getOneJSON(cedulaBuscar);
			if(client == null) {
				System.err.println("Nuloooo");
				JSONParser jsonParser = new JSONParser();
				String err = "{\"error\": \"No se encuentra\"}";
				JSONObject error = (JSONObject) jsonParser.parse(err);
				writter.println(error);
			} else {
				writter.println(client);
			}
			System.out.println(client);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private void searchProduct1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			PrintWriter writter = response.getWriter();
			Long codigoBuscar = Long.parseLong(request.getParameter("cod3"));
			System.err.println(codigoBuscar);
			JSONObject product = ProductJSON.getOneJSON(codigoBuscar);
			if(product == null) {
				System.err.println("Nuloooo");
				JSONParser jsonParser = new JSONParser();
				String err = "{\"error\": \"No se encuentra\"}";
				JSONObject error = (JSONObject) jsonParser.parse(err);
				writter.println(error);
			} else {
				writter.println(product);
			}
			System.out.println(product);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private void searchProduct2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			PrintWriter writter = response.getWriter();
			Long codigoBuscar = Long.parseLong(request.getParameter("cod2"));
			System.err.println(codigoBuscar);
			JSONObject product = ProductJSON.getOneJSON(codigoBuscar);
			if(product == null) {
				System.err.println("Nuloooo");
				JSONParser jsonParser = new JSONParser();
				String err = "{\"error\": \"No se encuentra\"}";
				JSONObject error = (JSONObject) jsonParser.parse(err);
				writter.println(error);
			} else {
				writter.println(product);
			}
			System.out.println(product);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private void searchProduct3(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			PrintWriter writter = response.getWriter();
			Long codigoBuscar = Long.parseLong(request.getParameter("cod1"));
			System.err.println(codigoBuscar);
			JSONObject product = ProductJSON.getOneJSON(codigoBuscar);
			if(product == null) {
				System.err.println("Nuloooo");
				JSONParser jsonParser = new JSONParser();
				String err = "{\"error\": \"No se encuentra\"}";
				JSONObject error = (JSONObject) jsonParser.parse(err);
				writter.println(error);
			} else {
				writter.println(product);
			}
			System.out.println(product);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
