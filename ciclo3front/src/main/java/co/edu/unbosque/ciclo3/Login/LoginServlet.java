package co.edu.unbosque.ciclo3.Login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.unbosque.ciclo3.Login.Login;
import co.edu.unbosque.ciclo3.Login.LoginJSON;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet/*")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getPathInfo();
		try {
			switch (action) {
			case "/login":
				showNewForm(request, response);
				break;
			case "/init":
				insertUser(request, response);
				break;
			}
		} catch (Exception e) {
			System.err.println("Error");
		}
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

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/Login/login-form.jsp");

		dispatcher.forward(request, response);
	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Login nuevo = new Login();
		nuevo.setUsuario(request.getParameter("usuario"));
		nuevo.setPassword(request.getParameter("password"));

		int rta = 0;
		try {
			PrintWriter writter = response.getWriter();
			rta = LoginJSON.postJSON(nuevo);
			System.out.println(rta);
			if (rta == 200) {
				writter.println("success");
			} else if (rta == 404)
				writter.println("No Exist");
			else if (rta == 401)
				writter.println("Incorrect");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
