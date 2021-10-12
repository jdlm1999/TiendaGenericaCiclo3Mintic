package co.edu.unbosque.ciclo3back.api;
import java.util.List;

public interface APIInterface <T>{
	public boolean guardar(String token, T agregar);
	public T obtener(String token, Long id);
	public List<T> listar(String token);
	public boolean actualizar(String token, T actualizar);
	public boolean eliminar(String token, Long id);
}
