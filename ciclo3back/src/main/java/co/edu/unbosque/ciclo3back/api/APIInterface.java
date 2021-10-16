package co.edu.unbosque.ciclo3back.api;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

public interface APIInterface <T>{
	public boolean guardar(String token, T agregar, HttpServletResponse response);
	public T obtener(String token, Long id, HttpServletResponse response);
	public List<T> listar(String token, HttpServletResponse response);
	public boolean actualizar(String token, T actualizar, HttpServletResponse response);
	public boolean eliminar(String token, Long id, HttpServletResponse response);
}
