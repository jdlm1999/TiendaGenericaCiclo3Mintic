package co.edu.unbosque.ciclo3.Producto;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import co.edu.unbosque.ciclo3.Usuario.Usuario;
import co.edu.unbosque.ciclo3.Usuario.UsuarioJSON;

/**
 * Servlet implementation class ProductoServlet
 */
@WebServlet("/ProductoServlet/*")
@MultipartConfig
public class ProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductoServlet() {
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
			case "/update":
				recibirArchivo(request, response);
				break;
			case "/show":
				cargarArchivo(request, response);
				break;
//			case "/delete":
//				deleteUser(request, response);
//				break;
			case "/detail":
				showDetail(request, response);
				break;
			default:
				listProduct(request, response);
				break;
			}
		} catch (Exception e) {
			System.err.println("Error: path");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
			dispatcher.forward(request, response);
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
	
	private void showDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/Producto/product-list.jsp");
		dispatcher.forward(request, response);
	}
	
	private void cargarArchivo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/Producto/carga-file.jsp");
		dispatcher.forward(request, response);
	}
	
	private void listProduct(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		try {
			PrintWriter writter = response.getWriter();
			JSONArray lista = ProductJSON.getJSON();
			System.out.println(lista);
			if(lista == null) {
				System.err.println("Nuloooo");
				JSONParser jsonParser = new JSONParser();
				String err = "{\"error\": \"No se encuentra\"}";
				JSONObject error = (JSONObject) jsonParser.parse(err);
				writter.println(error);
			}
			else
				writter.println(lista);
		} catch (IOException exception) {
			request.setAttribute("error", exception.getLocalizedMessage() + " No tienes autorizacion!!!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
			dispatcher.forward(request, response);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public void recibirArchivo(HttpServletRequest request, HttpServletResponse response) {
		try {
			Part archivo = request.getPart("archivo");
			String ruta = "D:\\Mintic\\Ciclo 3\\Grupal\\ciclo3front\\src\\main\\webapp\\Documentos\\";
			InputStream file = archivo.getInputStream();
			File copia = new File(ruta + "productos.csv");
			FileOutputStream escribir = new FileOutputStream(copia);
			int num = file.read();
			while (num != -1) {
				escribir.write(num);
				num = file.read();
			}
			escribir.close();
			file.close();
			
			System.out.println("Se cargo el archivo");
			
			
//			ProductJSON.cargarLibros();
			try {
				ProductJSON p = new ProductJSON("UTF-8");
//				p.addFormField("file", "file");
				p.addFilePart("file", copia);
//				p.addHeaderField("file", "file");
				System.out.println(p.finish());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}

//			JOptionPane.showMessageDialog(null, "Se Cargo el Archivo Correctamente.");
//			if (libDao.Cargar_Libros(Url + "prueba.csv")) {
//				response.sendRedirect("Libros.jsp?men=Se Inserto Los Libros Correctamente");
//			} else {
//				response.sendRedirect("Libros.jsp?men=No se Insertgo los Libros");
//			}

		} catch (Exception e) {
			System.err.println("Error al cargar el achivo.");
			System.err.println(e.getMessage());
		}
	}

}
