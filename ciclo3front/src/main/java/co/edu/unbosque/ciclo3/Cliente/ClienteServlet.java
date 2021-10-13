package co.edu.unbosque.ciclo3.Cliente;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.parser.ParseException;

import co.edu.unbosque.ciclo3.Usuario.Usuario;
import co.edu.unbosque.ciclo3.Usuario.UsuarioJSON;


/**
 * Servlet implementation class ClienteServlet
 */
@WebServlet("/ClienteServlet/*")
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	doGet(request, response);
    }
	
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insertClient":
				insertUser(request, response);
				break;
			case "/delete":
				deleteClient(request, response);
				break;
//			case "/edit":
//				showEditForm(request, response);
//				break;
			case "/update":
				updateClient(request, response);
				break;
			default:
				listUser(request, response);
				break;
			}
		} catch (Exception e) {
			System.err.println("Error");
		}
	}
	
	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {		
		try {
			ArrayList<Cliente> lista = ClienteJSON.getJSON();
			if(lista.isEmpty()) {
				System.out.println("Error: La lista se encuentra vacia");
			}
			request.setAttribute("lista", lista);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/Cliente/client-list.jsp");
			dispatcher.forward(request, response);
		} catch (IOException e) {
			request.setAttribute("error", e.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
			dispatcher.forward(request, response);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/Cliente/client-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		Cliente nuevo = new Cliente();
		nuevo.setNombre_cliente(request.getParameter("nombre"));
		nuevo.setEmail_cliente(request.getParameter("email"));
		nuevo.setTelefono_cliente(request.getParameter("telefono"));
		nuevo.setDireccion_cliente(request.getParameter("direccion"));
		nuevo.setCedula_cliente(Long.parseLong(request.getParameter("cedula")));
		
		int rta = 0;
		try {
			rta = ClienteJSON.postJSON(nuevo);
			response.sendRedirect("list");
//			PrintWriter writter = response.getWriter();
//			if (rta == 200)
//				writter.println(" Usuario con c�dula: " + nuevo.getCedula_usuario() + " ha sido creado con exito!!");
//			else
//				writter.println(" Error: No ha sido posible agregar al usuario con c�dula: " + nuevo.getCedula_usuario());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void updateClient(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Cliente actualizar = new Cliente();
		actualizar.setNombre_cliente(request.getParameter("nombre"));
		actualizar.setEmail_cliente(request.getParameter("email"));
		actualizar.setTelefono_cliente(request.getParameter("telefono"));
		actualizar.setDireccion_cliente(request.getParameter("direccion"));
		actualizar.setCedula_cliente(Long.parseLong(request.getParameter("cedula")));

		int rta = 0;
		try {
			rta = ClienteJSON.putJSON(actualizar);
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
		Long cedulaEliminar = Long.parseLong(request.getParameter("cedula"));
		int rta = 0;
		try {
			System.out.println(cedulaEliminar);
			rta = ClienteJSON.deleteJSON(cedulaEliminar);
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
