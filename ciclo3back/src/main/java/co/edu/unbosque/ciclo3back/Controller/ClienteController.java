package co.edu.unbosque.ciclo3back.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import co.edu.unbosque.ciclo3back.dao.ClienteDAO;
import co.edu.unbosque.ciclo3back.model.Cliente;

@Controller
public class ClienteController implements ControllerInterface<Cliente> {

	@Autowired
	private ClienteDAO clienteDao;

	@Override
	public boolean guardar(Cliente agregar) {
		try {
			clienteDao.save(agregar);
			return true;
		} catch (Exception e) {
			System.err.println("Error: Al agregar al cliente.");
			return false;
		}
	}

	@Override
	public Cliente obtenerById(Long id) {
		try {
			return clienteDao.findById(id).get();
		} catch (Exception e) {
			System.err.println("Error: Al obtener al cliente.");
			return null;
		}
	}

	@Override
	public List<Cliente> obtenerTodos() {
		try {
			return clienteDao.findAll();
		} catch (Exception e) {
			System.err.println("Error: Al obtener los clientes.");
			return null;
		}
	}

	@Override
	public boolean actualizar(Cliente actualizar) {
		try {
			clienteDao.save(actualizar);
			return true;
		} catch (Exception e) {
			System.err.println("Error: Al actualizar al cliente.");
			return false;
		}
	}

	@Override
	public boolean eliminar(Long id) {
		try {
			clienteDao.deleteById(id);
			return true;
		} catch (Exception e) {
			System.err.println("Error: Al eliminar al cliente.");
			return false;
		}
	}
}