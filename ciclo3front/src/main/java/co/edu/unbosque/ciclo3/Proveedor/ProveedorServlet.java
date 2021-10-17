package co.edu.unbosque.ciclo3.Proveedor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import co.edu.unbosque.ciclo3.Cliente.Cliente;
import co.edu.unbosque.ciclo3.Cliente.ClienteJSON;
import co.edu.unbosque.ciclo3.Usuario.Usuario;
import co.edu.unbosque.ciclo3.Usuario.UsuarioJSON;

/**
 * Servlet implementation class ProveedorServlet
 */
@WebServlet("/ProveedorServlet/*")
public class ProveedorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProveedorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getPathInfo();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertUser(request, response);
				break;
			case "/delete":
				deleteClient(request, response);
				break;
			case "/update":
				updateClient(request, response);
				break;
			case "/detail":
				showDetail(request, response);
				break;
			case "/busqueda":
				getOne(request, response);
				break;
			default:
				listProveedor(request, response);
				break;
			}
		} catch (Exception e) {
			System.err.println("Error: path");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Error.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void showDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/Proveedor/proveedor-detail.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/Proveedor/proveedor-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void listProveedor(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		try {
			ArrayList<Proveedor> lista = ProveedorJSON.getJSON();
			if (lista.isEmpty()) {
				System.out.println("Error: La lista se encuentra vacia");
			}
			request.setAttribute("lista", lista);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/Proveedor/proveedor-list.jsp");
			dispatcher.forward(request, response);
		} catch (IOException exception) {
			request.setAttribute("error", exception.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
			dispatcher.forward(request, response);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		Proveedor nuevo = new Proveedor();
		nuevo.setNombre_proveedor(request.getParameter("nombre"));
		nuevo.setCiudad_proveedor(request.getParameter("ciudad"));
		nuevo.setTelefono_proveedor(request.getParameter("telefono"));
		nuevo.setDireccion_proveedor(request.getParameter("direccion"));
		nuevo.setNit_proveedor(Long.parseLong(request.getParameter("nit")));
		
		int rta = 0;
		try {
			PrintWriter writter = response.getWriter();
			rta = ProveedorJSON.postJSON(nuevo);
			if (rta == 200)
				writter.println("Creado");
			else if (rta == 302)
				writter.println("Existe ID");
			else if (rta == 406)
				writter.println("Existe Credenciales");
			else if (rta == 412)
				writter.println("Vacias Credenciales");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getOne(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			PrintWriter writter = response.getWriter();
			Long nitBuscar = Long.parseLong(request.getParameter("busqueda"));
			JSONObject obtenido = ProveedorJSON.getOneJSON(nitBuscar);
			if(obtenido == null) {
				System.err.println("Nuloooo");
				JSONParser jsonParser = new JSONParser();
				String err = "{\"error\": \"No se encuentra\"}";
				JSONObject error = (JSONObject) jsonParser.parse(err);
				writter.println(error);
			}
			else
				writter.println(obtenido);
		} catch (IOException e) {
			request.setAttribute("error", e.getMessage() + " No tienes autorizacion!!!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
			dispatcher.forward(request, response);
		} catch (ParseException e) {
			System.err.println(e.getMessage());
		}
	}
	
	private void updateClient(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Proveedor actualizar = new Proveedor();
		actualizar.setNombre_proveedor(request.getParameter("nombre"));
		actualizar.setCiudad_proveedor(request.getParameter("ciudad"));
		actualizar.setTelefono_proveedor(request.getParameter("telefono"));
		actualizar.setDireccion_proveedor(request.getParameter("direccion"));
		actualizar.setNit_proveedor(Long.parseLong(request.getParameter("nit")));

		int rta = 0;
		try {
			rta = ProveedorJSON.putJSON(actualizar);
			response.sendRedirect("list");
//			PrintWriter writter = response.getWriter();
//			if (rta == 200)
//				writter.println(" Usuario con c�dula: " + actualizar.getCedula_usuario() + " ha sido actualizado con exito!!");
//			else
//				writter.println(" Error: No ha sido posible actualizar al usuario con c�dula: " + actualizar.getCedula_usuario());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void deleteClient(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Long nitEliminar = Long.parseLong(request.getParameter("nit"));
		int rta = 0;
		try {
			System.out.println(nitEliminar);
			rta = ProveedorJSON.deleteJSON(nitEliminar);
			response.sendRedirect("list");
			System.out.println(rta);
//			PrintWriter writter = response.getWriter();
//			if (rta == 200)
//				writter.println(" Usuario con c�dula: " + cedulaEliminar + " ha sido eliminado con exito!!");
//			else
//				writter.println(" Error: No ha sido posible eliminar al usuario con cedul: " + cedulaEliminar);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
