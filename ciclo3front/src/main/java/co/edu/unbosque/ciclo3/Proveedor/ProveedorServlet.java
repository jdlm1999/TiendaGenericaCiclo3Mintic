package co.edu.unbosque.ciclo3.Proveedor;

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
//			case "/new":
//				showNewForm(request, response);
//				break;
//			case "/insert":
//				insertUser(request, response);
//				break;
//			case "/delete":
//				deleteUser(request, response);
//				break;
//			case "/update":
//				updateUser(request, response);
//				break;
			default:
				listUser(request, response);
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
	
	private void listUser(HttpServletRequest request, HttpServletResponse response)
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

}
