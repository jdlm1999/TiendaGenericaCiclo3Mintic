package co.edu.unbosque.ciclo3back.Controller;
import java.util.List;

public interface ControllerInterface<T> {
	public boolean guardar(T agregar);
	public T obtenerById(Long id);
	public List<T> obtenerTodos();
	public boolean actualizar(T actualizar);
	public boolean eliminar(Long id);
}
