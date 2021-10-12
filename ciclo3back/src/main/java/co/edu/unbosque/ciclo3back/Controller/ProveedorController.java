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
	public boolean guardar(Proveedor agregar) {
		try {
			proveedorDao.save(agregar);
			return true;
		} catch (Exception e) {
			System.err.println("Error: Al agregar al proveedor.");
			return false;
		}
	}

	@Override
	public Proveedor obtenerById(Long id) {
		try {
			return proveedorDao.findById(id).get();
		} catch (Exception e) {
			System.err.println("Error: Al obtener al proveedor.");
			return null;
		}
	}

	@Override
	public List<Proveedor> obtenerTodos() {
		try {
			return proveedorDao.findAll();
		} catch (Exception e) {
			System.err.println("Error: Al obtener los proveedores.");
			return null;
		}
	}

	@Override
	public boolean actualizar(Proveedor actualizar) {
		try {
			proveedorDao.save(actualizar);
			return true;
		} catch (Exception e) {
			System.err.println("Error: Al actualizar al proveedor.");
			return false;
		}
	}

	@Override
	public boolean eliminar(Long id) {
		try {
			proveedorDao.deleteById(id);
			return true;
		} catch (Exception e) {
			System.err.println("Error: Al eliminar al proveedor.");
			return false;
		}
	}
}
