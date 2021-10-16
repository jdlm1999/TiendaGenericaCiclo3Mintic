package co.edu.unbosque.ciclo3back.Controller;
import java.util.List;

public interface ControllerInterface<T> {
	public String guardar(T agregar);
	public String guardar(T agregar, String token);
	public T obtenerById(Long id, String token);
	public List<T> obtenerTodos(String token);
	public String actualizar(T actualizar, String token);
	public String eliminar(Long id, String token);
}
