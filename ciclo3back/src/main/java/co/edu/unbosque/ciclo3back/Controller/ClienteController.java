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
	public String guardar(Cliente agregar) {
		try {
			clienteDao.save(agregar);
			return "";
		} catch (Exception e) {
			System.err.println("Error: Al agregar al cliente.");
			return "";
		}
	}

	@Override
	public Cliente obtenerById(Long id, String token) {
		try {
			return clienteDao.findById(id).get();
		} catch (Exception e) {
			System.err.println("Error: Al obtener al cliente.");
			return null;
		}
	}

	@Override
	public List<Cliente> obtenerTodos(String token) {
		try {
			return clienteDao.findAll();
		} catch (Exception e) {
			System.err.println("Error: Al obtener los clientes.");
			return null;
		}
	}

	@Override
	public String actualizar(Cliente actualizar, String token) {
		try {
			clienteDao.save(actualizar);
			return "";
		} catch (Exception e) {
			System.err.println("Error: Al actualizar al cliente.");
			return "";
		}
	}

	@Override
	public String eliminar(Long id, String token) {
		try {
			clienteDao.deleteById(id);
			return "";
		} catch (Exception e) {
			System.err.println("Error: Al eliminar al cliente.");
			return "";
		}
	}
}