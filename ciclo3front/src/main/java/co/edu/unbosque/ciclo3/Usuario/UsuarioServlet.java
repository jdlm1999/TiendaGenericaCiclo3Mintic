package co.edu.unbosque.ciclo3.Usuario;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.parser.ParseException;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/UsuarioServlet/*")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsuarioServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
				deleteUser(request, response);
				break;
//			case "/edit":
//				showEditForm(request, response);
//				break;
			case "/update":
				updateUser(request, response);
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
			ArrayList<Usuario> lista = UsuarioJSON.getJSON();
			if(lista.isEmpty()) {
				System.out.println("Error: La lista se encuentra vacia");
			}
			request.setAttribute("lista", lista);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/Usuario/user-list.jsp");
			dispatcher.forward(request, response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Error al listar los usuarios.");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/Usuario/user-form.jsp");
		dispatcher.forward(request, response);
	}
//
//	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
//			throws SQLException, ServletException, IOException {
//		int id = Integer.parseInt(request.getParameter("id"));
//		User existingUser = userDAO.selectUser(id);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
//		request.setAttribute("user", existingUser);
//		dispatcher.forward(request, response);
//
//	}
//
	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		Usuario nuevo = new Usuario();
		nuevo.setUsuario(request.getParameter("usuario"));
		nuevo.setPassword(request.getParameter("password"));
		nuevo.setNombre_usuario(request.getParameter("nombre"));
		nuevo.setEmail_usuario(request.getParameter("email"));
		nuevo.setCedula_usuario(Long.parseLong(request.getParameter("cedula")));
		
		int rta = 0;
		try {
			rta = UsuarioJSON.postJSON(nuevo);
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

	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		Usuario actualizar = new Usuario();
		actualizar.setUsuario(request.getParameter("usuario"));
		actualizar.setPassword(request.getParameter("password"));
		actualizar.setNombre_usuario(request.getParameter("nombre"));
		actualizar.setEmail_usuario(request.getParameter("email"));
		actualizar.setCedula_usuario(Long.parseLong(request.getParameter("cedula")));
		
		int rta = 0;
		try {
			rta = UsuarioJSON.putJSON(actualizar);
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

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		Long cedulaEliminar = Long.parseLong(request.getParameter("cedula"));
		int rta = 0;
		try {
			rta = UsuarioJSON.deleteJSON(cedulaEliminar);
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
