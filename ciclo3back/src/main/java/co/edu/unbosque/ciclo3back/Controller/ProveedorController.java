package co.edu.unbosque.ciclo3back.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import co.edu.unbosque.ciclo3back.dao.ProveedorDAO;
import co.edu.unbosque.ciclo3back.model.Proveedor;

@Controller
public class ProveedorController implements ControllerInterface<Proveedor>{

	@Autowired
	private ProveedorDAO proveedorDao;

	@Override
	public String guardar(Proveedor agregar) {
		try {
			proveedorDao.save(agregar);
			return "";
		} catch (Exception e) {
			System.err.println("Error: Al agregar al proveedor.");
			return "";
		}
	}

	@Override
	public Proveedor obtenerById(Long id, String token) {
		try {
			return proveedorDao.findById(id).get();
		} catch (Exception e) {
			System.err.println("Error: Al obtener al proveedor.");
			return null;
		}
	}

	@Override
	public List<Proveedor> obtenerTodos(String token) {
		try {
			return proveedorDao.findAll();
		} catch (Exception e) {
			System.err.println("Error: Al obtener los proveedores.");
			return null;
		}
	}

	@Override
	public String actualizar(Proveedor actualizar, String token) {
		try {
			proveedorDao.save(actualizar);
			return "";
		} catch (Exception e) {
			System.err.println("Error: Al actualizar al proveedor.");
			return "";
		}
	}

	@Override
	public String eliminar(Long id, String token) {
		try {
			proveedorDao.deleteById(id);
			return "";
		} catch (Exception e) {
			System.err.println("Error: Al eliminar al proveedor.");
			return "";
		}
	}
}
