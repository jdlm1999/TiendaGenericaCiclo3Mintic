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
			case "/newClient":
				showNewForm(request, response);
				break;
			case "/insertClient":
				insertUser(request, response);
				break;
//			case "/deleteClient":
//				deleteUser(request, response);
//				break;
////			case "/edit":
////				showEditForm(request, response);
////				break;
//			case "/updateClient":
//				updateUser(request, response);
//				break;
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
			System.out.println("----------------------------------------------------------------------");
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


}
